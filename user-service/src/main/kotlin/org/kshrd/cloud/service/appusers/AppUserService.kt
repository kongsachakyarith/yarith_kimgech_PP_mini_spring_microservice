package org.kshrd.cloud.service.appusers

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.entity.AppUser
import org.kshrd.cloud.model.request.AppUserProfileRequest
import org.kshrd.cloud.model.request.AppUserRequest
import reactor.core.publisher.Mono
import java.util.UUID

interface AppUserService {

    fun findByUserId(appUserId: UUID): Mono<AppUser>

    fun createUser(appUserRequest: AppUserRequest):Mono<AppUserDto>

    fun deleteById(id: UUID): Mono<AppUser>

//    fun updateById(appUserProfileRequest: AppUserProfileRequest, id: UUID): Mono<AppUserDto>
}