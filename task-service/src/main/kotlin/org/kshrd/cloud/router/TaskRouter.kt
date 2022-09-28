package org.kshrd.cloud.router

import org.kshrd.cloud.config.TaskOperations
import org.kshrd.cloud.handler.TaskHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

class TaskRouter {
    @Configuration
    @TaskOperations
    class AppUserRouter(val taskHandler: TaskHandler){
        //
        @Bean
        fun taskRouter(): RouterFunction<ServerResponse> =
            router{
                "/api/v1".nest{
                    GET("/tasks/{groupId}",taskHandler::getAllTaskById)
                    POST("/tasks", taskHandler::createTask)
                    DELETE("/tasks/{taskId}", taskHandler::deleteTaskById)
                }

            }

    }
}