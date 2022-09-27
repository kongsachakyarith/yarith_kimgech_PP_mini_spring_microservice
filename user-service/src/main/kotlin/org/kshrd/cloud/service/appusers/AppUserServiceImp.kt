package com.kshrd.demo.userservice.service.appusers

import com.kshrd.demo.userservice.model.entity.AppUser
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class AppUserServiceImp(val appUserRepository: AppUserRepository):AppUserService  {
    override fun findByUserId(appUserId: Long): Mono<AppUser> {
        return appUserRepository.findById(appUserId)
    }
}