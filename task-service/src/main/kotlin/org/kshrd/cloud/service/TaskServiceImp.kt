package org.kshrd.cloud.service

import org.kshrd.cloud.handler.Response
import org.kshrd.cloud.model.dto.TaskDto
import org.kshrd.cloud.model.entity.Task
import org.kshrd.cloud.model.request.TaskRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class TaskServiceImp (val taskRepository: TaskRepository): TaskService {
    override fun findByGroupId(groupId: UUID): Mono<Task> {
        return taskRepository.findByGroupId(groupId)
    }

    override fun deleteTaskById(taskId: UUID): Mono<Response> {
        return taskRepository.deleteById(taskId).thenReturn(
            Response("Delete successfully", "200")
        )
    }

    override fun createTask(taskRequest: TaskRequest): Mono<TaskDto> {
       return taskRepository.save(taskRequest.toEntity()).map { it.toDto() }
    }
}