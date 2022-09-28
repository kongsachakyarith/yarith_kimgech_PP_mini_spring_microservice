package org.kshrd.cloud.service.appusers

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.dto.Response
import org.kshrd.cloud.model.request.AppUserProfileRequest
import org.kshrd.cloud.model.request.AppUserRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class AppUserServiceImp(val appUserRepository: AppUserRepository): AppUserService {
    override fun findByUserId(appUserId: UUID): Mono<AppUserDto> {
        return appUserRepository.findAppUserByAuthId(appUserId).map { it.toDto() }
    }

    override fun createUser(appUserRequest: AppUserRequest): Mono<AppUserDto> {
        return appUserRepository
            .save(appUserRequest.toEntity())
            .map { res -> res.toDto() }
    }

    override fun deleteById(id: UUID): Mono<Response> {
//        if(id!=null){
//            return appUserRepository.deleteAppUserByAuthId(id).thenReturn(Response("Successfully deleted user"))
//        } else return { Response("f")}
        return appUserRepository.deleteAppUserByAuthId(id).thenReturn(Response("Successfully deleted user"))
    }

    override fun updateById(appUserProfileRequest: AppUserProfileRequest, id: UUID): Mono<AppUserDto> {
       return appUserRepository
           .updateById(id,appUserProfileRequest.username,appUserProfileRequest.profileImage,appUserProfileRequest.firstName,appUserProfileRequest.lastName)
           .map { it.toDto() }
    }

//    override fun updateById(appUserProfileRequest: AppUserProfileRequest, id: UUID): Mono<AppUserDto> {
//        return appUserRepository.
//    }
}