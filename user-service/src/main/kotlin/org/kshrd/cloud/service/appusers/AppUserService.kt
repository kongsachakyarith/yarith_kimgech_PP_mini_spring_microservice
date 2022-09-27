package org.kshrd.cloud.service.appusers

//import org.kshrd.cloud.model.entity.AppUser
import org.kshrd.cloud.model.entity.AppUser
import reactor.core.publisher.Mono
import java.util.UUID

interface AppUserService {

    fun findByUserId(appUserId: UUID): Mono<AppUser>
}