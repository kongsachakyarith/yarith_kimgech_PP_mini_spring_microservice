package org.kshrd.cloud.handler

import org.kshrd.cloud.model.dto.AppUserDto
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

    fun testing(req: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().body(Mono.just("Hii"), String::class.java)

}