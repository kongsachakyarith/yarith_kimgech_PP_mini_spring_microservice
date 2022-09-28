package org.kshrd.cloud.config

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.request.AppUserRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.Explode
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.enums.ParameterStyle
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.kshrd.cloud.handler.AppUserHandler
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMethod

@RouterOperations(
    value = [
        // this endpoint is a GET request with no paramters and returns an array
//        RouterOperation(
//            path = "/api/v1/users/{id}",
//            method = [RequestMethod.GET],
//            produces = [MediaType.APPLICATION_JSON_VALUE],
//            beanClass = AppUserHandler::class,
//            beanMethod = "getAllUserById",
//            operation = Operation(
//                operationId = "getAllUserById", responses = [ApiResponse(
//                    content = [Content(array = ArraySchema(schema = Schema(implementation = AppUserDto::class)))]
//                )]
//            )
//        ),
        // this endpoint is a POST request with a request body and returns an object
//        RouterOperation(
//            path = "/api/v1/users",
//            method = [RequestMethod.POST],
//            produces = [MediaType.APPLICATION_JSON_VALUE],
//            beanClass = AppUserHandler::class,
//            beanMethod = "createAppUser",
//            operation = Operation(
//                operationId = "createAppUser",
//                requestBody = RequestBody(content = [Content(schema = Schema(implementation = AppUserRequest::class))]),
//                responses = [ApiResponse(
//                    responseCode = "200", content = [Content(schema = Schema(implementation = AppUserDto::class))]
//                )]
//            )
//        ),
        // this endpoint is a GET request that takes a path variable and returns an array
            RouterOperation(
                path = "/api/v1/users/{id}",
                method = [RequestMethod.GET],
                produces = [MediaType.APPLICATION_JSON_VALUE],
                beanClass = AppUserHandler::class,
                beanMethod = "getAllUserById",
                operation = Operation(
                    operationId = "getAllUserById", parameters = [Parameter(
                        name = "id",
                        `in` = ParameterIn.PATH, // use this to accept a path variable
                        style = ParameterStyle.SIMPLE,
                        explode = Explode.FALSE,
                        required = true,
                    )], responses = [ApiResponse(
                        responseCode = "200",
                        content = [Content(array = ArraySchema(schema = Schema(implementation = AppUserDto::class)))]
                    )]
                )
            ),
    ]
)
annotation class AppUserOperations