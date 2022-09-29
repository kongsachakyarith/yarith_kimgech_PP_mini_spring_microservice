package org.kshrd.cloud.service

import org.kshrd.cloud.handler.AppUser
import org.kshrd.cloud.handler.Response
import org.kshrd.cloud.model.dto.TaskDto
import org.kshrd.cloud.model.entity.Task
import org.kshrd.cloud.model.request.TaskRequest
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.util.*

@Service
class TaskServiceImp (val taskRepository: TaskRepository,
@Qualifier("AppUser") val assignedTo: WebClient, val createBy: WebClient): TaskService {


    override fun findByGroupId(groupId: UUID, assignedTo: UUID): Mono<Task> {
        return taskRepository.findByGroupIdAndAssignedTo(groupId,assignedTo)
    }


    override fun deleteTaskById(taskId: UUID): Mono<Response> {
        return taskRepository.deleteTaskById(taskId).thenReturn(
            Response("Delete successfully", "200")
        )
    }

    override fun createTask(taskRequest: TaskRequest): Mono<TaskDto> {

      val createTask =  taskRepository.save(taskRequest.toEntity()).map { it.toDto() }

        val gg =  assignedTo.get()
            .uri("/api/v1/users", "60347c05-5920-46d5-bf16-29937fa41d9b")
            .retrieve()
            .bodyToMono(AppUser::class.java)

        val TaskFlux = createTask.zipWith(gg)
            .map {
                val task = it.t1
                val assignedTo = it.t2
                val TaskResponse = task
                TaskResponse.assignedTo = assignedTo
                TaskResponse
            }
        val ggs =  createBy.get()
            .uri("/api/v1/users", assignedTo)
            .retrieve()
            .bodyToMono(AppUser::class.java)

        val AssignedFlux = TaskFlux.zipWith(ggs)
            .map {
                val tasks = it.t1
                val createBy = it.t2
                val AssignedResponses = tasks
                AssignedResponses.createBy  = createBy
                AssignedResponses
            }
        return AssignedFlux;

    }
}