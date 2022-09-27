package com.kshrd.demo.userservice.service.appusers

import org.kshrd.cloud.model.entity.AppUser
import reactor.core.publisher.Mono

interface AppUserService {

    fun findByUserId(appUserId: Long): Mono<AppUser>
}