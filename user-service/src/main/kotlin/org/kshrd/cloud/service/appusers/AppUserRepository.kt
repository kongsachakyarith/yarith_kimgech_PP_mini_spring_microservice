package com.kshrd.demo.userservice.service.appusers

import org.kshrd.cloud.model.entity.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AppUserRepository : ReactiveCrudRepository<AppUser,Long> {

//    fun findAppUserById(appUserId: Mono<UUID>): Mono<AppUser>

}