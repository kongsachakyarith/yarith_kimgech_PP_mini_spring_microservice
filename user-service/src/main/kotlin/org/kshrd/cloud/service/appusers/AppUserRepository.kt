package com.kshrd.demo.userservice.service.appusers

import com.kshrd.demo.userservice.model.entity.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface AppUserRepository : ReactiveCrudRepository<AppUser,Long> {

//    fun findAppUserById(appUserId: Mono<UUID>): Mono<AppUser>

}