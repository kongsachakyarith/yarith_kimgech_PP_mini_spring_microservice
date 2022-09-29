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
                      @Qualifier("AppUser") val assignedTo: WebClient): TaskService {


    override fun findByGroupId(groupId: UUID, assignedId: UUID): Mono<TaskDto> {


        val taskMono = taskRepository.findByGroupIdAndAssignedTo(groupId,assignedId).map { it.toDto() }

        val createdByd = assignedTo.get()
            .uri("/api/v1/users/{id}", "3986fced-4424-4825-9912-589e626e53b3")
            .retrieve()
            .bodyToMono(AppUser::class.java)

        val taskGetAll = taskMono.zipWith(createdByd)
            .map {
                val task = it.t1
                val createdBy = it.t2
                val taskResponse = task
                taskResponse.createBy = createdBy
                taskResponse
            }

        val assignedToMono = assignedTo.get()
            .uri("/api/v1/users/{id}",assignedId )
            .retrieve()
            .bodyToMono(AppUser::class.java)


        val taskCreatedByAssignedToMono = taskGetAll.zipWith(assignedToMono)
            .map {
                val taskCreatedBy = it.t1
                val assignedTo = it.t2
                val taskCreatedByResponse = taskCreatedBy
                taskCreatedByResponse.assignedTo = assignedTo
                taskCreatedByResponse
            }

        return taskCreatedByAssignedToMono

    }



    override fun deleteTaskById(taskId: UUID): Mono<Response> {
        return taskRepository.deleteTaskById(taskId).thenReturn(
            Response("Delete successfully", "200")
        )
    }

    override fun createTask(taskRequest: TaskRequest): Mono<TaskDto> {
        val assignedToUser = taskRequest.assignedTo
        val createTask = taskRepository.save(taskRequest.toEntity()).map { it.toDto() }

        val createdBy = assignedTo.get()
            .uri("/api/v1/users/{id}", "60347c05-5920-46d5-bf16-29937fa41d9b")
            .retrieve()
            .bodyToMono(AppUser::class.java)

        val taskCreated = createTask.zipWith(createdBy)
            .map {
                val task = it.t1
                val createdBy = it.t2
                val taskResponse = task
                taskResponse.createBy = createdBy
                taskResponse
            }

        val assignedTo = assignedTo.get()
            .uri("/api/v1/users/{id}", assignedToUser)
            .retrieve()
            .bodyToMono(AppUser::class.java)


        val taskAssignedToMono = taskCreated.zipWith(assignedTo)
            .map {
                val task = it.t1
                val assignedTo = it.t2
                val taskAssignedToMono = task
                taskAssignedToMono.assignedTo = assignedTo
                taskAssignedToMono
            }

        return taskAssignedToMono


    }
}