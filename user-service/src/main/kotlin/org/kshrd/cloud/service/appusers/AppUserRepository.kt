package org.kshrd.cloud.service.appusers

import org.kshrd.cloud.model.entity.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface AppUserRepository : ReactiveCrudRepository<AppUser,Long> {

    fun findById(appUserId: UUID): Mono<AppUser>

}