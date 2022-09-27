package com.kshrd.demo.userservice.handler

import com.kshrd.demo.userservice.model.dto.AppUserDto
import com.kshrd.demo.userservice.service.appusers.AppUserService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class AppUserHandler(val appUserService: AppUserService) {

//    fun findByUserById(req:ServerRequest): Mono<ServerResponse> {
//        val appUserId = req.pathVariable("id")
//
//       return ServerResponse.ok().body(appUserService.findByUserId("appUserId"),AppUserDto::class.java)
//
//    }

}