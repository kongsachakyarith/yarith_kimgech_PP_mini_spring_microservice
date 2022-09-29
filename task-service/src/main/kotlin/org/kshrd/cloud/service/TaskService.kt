package org.kshrd.cloud.service

import org.kshrd.cloud.handler.Response
import org.kshrd.cloud.model.dto.TaskDto
import org.kshrd.cloud.model.entity.Task
import org.kshrd.cloud.model.request.TaskRequest
import org.springframework.data.r2dbc.repository.Query
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface TaskService {

    fun findByGroupId(groupId: UUID, assignedTo: UUID): Mono<Task>

    fun deleteTaskById(taskId: UUID) : Mono<Response>

    fun createTask(taskRequest: TaskRequest) : Mono<TaskDto>
}