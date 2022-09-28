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
import org.kshrd.cloud.handler.GroupHandler
import org.kshrd.cloud.model.dto.GroupDto
import org.kshrd.cloud.model.dto.MemberDto
import org.kshrd.cloud.model.request.GroupRequest
import org.kshrd.cloud.model.request.MemberRequest
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMethod

@RouterOperations(
    value = [
        // this endpoint is a GET request with no paramters and returns an array
        RouterOperation(
            path = "/api/v1/users/profile/{id}",
            method = [RequestMethod.PUT],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = AppUserHandler::class,
            beanMethod = "updateUserProfileById",
            operation = Operation(
                operationId = "updateUserProfileById", parameters = [Parameter(
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
        // this endpoint is a POST request with a request body and returns an object
        RouterOperation(
            path = "/api/v1/users",
            method = [RequestMethod.POST],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = AppUserHandler::class,
            beanMethod = "createAppUser",
            operation = Operation(
                operationId = "createAppUser",
                requestBody = RequestBody(content = [Content(schema = Schema(implementation = AppUserRequest::class))]),
                responses = [ApiResponse(
                    responseCode = "200", content = [Content(schema = Schema(implementation = AppUserDto::class))]
                )]
            )
        ),
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
        RouterOperation(
            path = "/api/v1/users/{id}",
            method = [RequestMethod.DELETE],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = AppUserHandler::class,
            beanMethod = "deleteUserById",
            operation = Operation(
                operationId = "deleteUserById", parameters = [Parameter(
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

@RouterOperations(
    value = [
        RouterOperation(
            path = "/api/v1/groups",
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = GroupHandler::class,
            beanMethod = "getAllGroups",
            operation = Operation(
                operationId = "getAllGroups", responses = [ApiResponse(
                    content = [Content(array = ArraySchema(schema = Schema(implementation = GroupDto::class)))]
                )]
            )
        ),
        // this endpoint is a POST request with a request body and returns an object
        RouterOperation(
            path = "/api/v1/groups",
            method = [RequestMethod.POST],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = GroupHandler::class,
            beanMethod = "createGroup",
            operation = Operation(
                operationId = "createGroup",
                requestBody = RequestBody(content = [Content(schema = Schema(implementation = GroupRequest::class))]),
                responses = [ApiResponse(
                    responseCode = "200", content = [Content(schema = Schema(implementation = GroupDto::class))]
                )]
            )
        ),
        // this endpoint is a GET request that takes a path variable and returns an array
        RouterOperation(
            path = "/api/v1/groups/{id}",
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = GroupHandler::class,
            beanMethod = "findById",
            operation = Operation(
                operationId = "findById", parameters = [Parameter(
                    name = "id",
                    `in` = ParameterIn.PATH, // use this to accept a path variable
                    style = ParameterStyle.SIMPLE,
                    explode = Explode.FALSE,
                    required = true,
                )], responses = [ApiResponse(
                    responseCode = "200",
                    content = [Content(array = ArraySchema(schema = Schema(implementation = GroupDto::class)))]
                )]
            )
        ),
        RouterOperation(
            path = "/api/v1/groups/{id}/users",
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = AppUserHandler::class,
            beanMethod = "findGroupMember",
            operation = Operation(
                operationId = "findGroupMember", parameters = [Parameter(
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
        RouterOperation(
            path = "/api/v1/groups/members",
            method = [RequestMethod.POST],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            beanClass = GroupHandler::class,
            beanMethod = "createMemberGroup",
            operation = Operation(
                operationId = "createMemberGroup",
                requestBody = RequestBody(content = [Content(schema = Schema(implementation = MemberRequest::class))]),
                responses = [ApiResponse(
                    responseCode = "200", content = [Content(schema = Schema(implementation = MemberDto::class))]
                )]
            )
        ),
    ]
)
annotation class GroupOperations