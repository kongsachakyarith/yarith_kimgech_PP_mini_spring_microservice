package org.kshrd.cloud.service.appusers

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.entity.AppUser
import org.kshrd.cloud.model.request.AppUserRequest
import org.springframework.cloud.client.loadbalancer.Response
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class AppUserServiceImp(val appUserRepository: AppUserRepository): AppUserService {
    override fun findByUserId(appUserId: UUID): Mono<AppUser> {
        return appUserRepository.findAppUserById(appUserId)
    }

    override fun createUser(appUserRequest: AppUserRequest): Mono<AppUserDto> {
        return appUserRepository
            .save(appUserRequest.toEntity())
            .map { res -> res.toDto() }
    }

    override fun deleteById(id: UUID): Mono<AppUser> {
        return appUserRepository.deleteAppUserById(id)
    }
}