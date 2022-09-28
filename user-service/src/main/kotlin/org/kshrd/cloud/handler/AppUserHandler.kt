package org.kshrd.cloud.handler

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.entity.AppUser
import org.kshrd.cloud.model.request.AppUserProfileRequest
import org.kshrd.cloud.model.request.AppUserRequest
import org.kshrd.cloud.service.appusers.AppUserService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.*

@Component
class AppUserHandler(val appUserService: AppUserService){

    fun getAllUserById(req:ServerRequest): Mono<ServerResponse> {
        val appUserId = UUID.fromString(req.pathVariable("id"))
       return ServerResponse.ok().body(appUserService.findByUserId(appUserId), AppUserDto::class.java)
    }

    fun createAppUser(req: ServerRequest): Mono<ServerResponse> =
        req.bodyToMono(AppUserRequest::class.java)
            .flatMap { appUserService.createUser(it)
            }
            .flatMap {
                ServerResponse.ok().bodyValue(it)
            }

    fun deleteUserById(req: ServerRequest): Mono<ServerResponse>{
        val id = UUID.fromString(req.pathVariable("id"))
        return ServerResponse.ok()
            .body(appUserService.deleteById(id),AppUser::class.java)
    }

    fun updateUserProfileById(req: ServerRequest): Mono<ServerResponse>{
        val userId = UUID.fromString(req.pathVariable("id"))
        return req.bodyToMono(AppUserProfileRequest::class.java)
            .flatMap { appUserService.updateById(it,userId) }
            .flatMap { ServerResponse.ok().bodyValue(it) }
    }
//    fun testing(req: ServerRequest): Mono<ServerResponse> =
//        ServerResponse.ok().body(Mono.just("Hii"), String::class.java)

}