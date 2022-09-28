package org.kshrd.cloud.service.appusers

import org.kshrd.cloud.model.entity.AppUser
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class AppUserServiceImp(val appUserRepository: AppUserRepository): AppUserService {
    override fun findByUserId(appUserId: UUID): Mono<AppUser> {
        return appUserRepository.findById(appUserId)
    }
}