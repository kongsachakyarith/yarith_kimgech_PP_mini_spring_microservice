package com.kshrd.demo.userservice.service.appusers

import com.kshrd.demo.userservice.model.entity.AppUser
import reactor.core.publisher.Mono
import java.util.UUID

interface AppUserService {

    fun findByUserId(appUserId: Long): Mono<AppUser>
}