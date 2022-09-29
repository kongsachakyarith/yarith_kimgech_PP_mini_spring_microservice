package org.kshrd.cloud.handler

import org.kshrd.cloud.model.dto.TaskDto
import org.kshrd.cloud.model.entity.Task
import org.kshrd.cloud.model.request.TaskRequest
import org.kshrd.cloud.service.TaskService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.*
import javax.validation.constraints.Email

data class AppUser(
    val id: UUID,
    val username : String,
    val email: String,
    val firstName: String,
    val lastName: String
)

@Component
class TaskHandler(private val taskService: TaskService) {
    fun getAllTaskById(req: ServerRequest): Mono<ServerResponse> {
        val group = UUID.fromString(req.pathVariable("group"))
        val assignedTo = UUID.fromString(req.pathVariable("assignedTo"))
        return ServerResponse.ok().body(taskService.findByGroupId(group, assignedTo), TaskDto::class.java)

    }

    fun createTask(req: ServerRequest) : Mono<ServerResponse>{
        val taskRequestMono = req.bodyToMono(TaskRequest::class.java)
        val taskResultMono: Mono<TaskDto> = taskRequestMono.flatMap { taskService.createTask(it) }
        return ServerResponse.ok().body(taskResultMono, Task::class.java)
    }

    fun deleteTaskById(req: ServerRequest): Mono<ServerResponse>{
        val id = UUID.fromString(req.pathVariable("id"))
        return ServerResponse.ok().body(taskService.deleteTaskById(id), Task::class.java)
    }
}