package org.kshrd.cloud.config

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.Explode
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.enums.ParameterStyle
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.kshrd.cloud.handler.TaskHandler
import org.kshrd.cloud.model.dto.TaskDto
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMethod

    @RouterOperations(
        value = [

            RouterOperation(
                path = "/api/v1/task",
                method = [RequestMethod.POST],
                produces = [MediaType.APPLICATION_JSON_VALUE],
                beanClass = AppUserHandler::class,
                beanMethod = "createTask",
                operation = Operation(
                    operationId = "createTask",
                    requestBody = RequestBody(content = [Content(schema = Schema(implementation = TaskRequest::class))]),
                    responses = [ApiResponse(
                        responseCode = "200", content = [Content(schema = Schema(implementation = AppUserDto::class))]
                    )]
                )
            ),

            RouterOperation(
                path = "/api/v1/tasks/{groupId}",
                method = [RequestMethod.DELETE],
                produces = [MediaType.APPLICATION_JSON_VALUE],
                beanClass = AppUserHandler::class,
                beanMethod = "deleteTaskById",
                operation = Operation(
                    operationId = "deleteTaskById", parameters = [Parameter(
                        name = "id",
                        `in` = ParameterIn.PATH, // use this to accept a path variable
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                    )], responses = [ApiResponse(
                        responseCode = "200",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = TaskDto::class)))]
                    )]
                )
            ),
        ]
    )
            RouterOperation(
                path = "/api/v1/tasks/{groupId}",
                method = [RequestMethod.GET],
                produces = [MediaType.APPLICATION_JSON_VALUE],
                beanClass = TaskHandler::class,
                beanMethod = "getAllTaskByGroupId",
                operation = Operation(
                    operationId = "getAllTaskByGroupId", parameters = [Parameter(
                        name = "id",
                        `in` = ParameterIn.PATH, // use this to accept a path variable
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                    )], responses = [ApiResponse(
                        responseCode = "200",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = TaskDto::class)))]
                    )]
                )
            ),
        ]
    )
    annotation class TaskOperations