package org.kshrd.cloud.service.appusers

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.dto.Response
import org.kshrd.cloud.model.entity.AppUser
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

interface AppUserRepository : ReactiveCrudRepository<AppUser,Int> {

    fun findAppUserByAuthId(appUserId: UUID): Mono<AppUser>

    fun deleteAppUserByAuthId(appUserId: UUID):Mono<AppUser>

    @Query(value = "update app_users " + "set username = :username, " + "profile_image = :profileImage, " +
            "first_name = :firstName, " + "last_name = :lastName " + "where auth_id = :id " +
            "returning * ")
    fun updateById(id: UUID, username: String, profileImage: String, firstName: String, lastName: String) : Mono<AppUser>

    @Query(value = "select id from app_users where auth_id = :id")
    fun findUserIdById(id: UUID): Mono<Int>

    @Query(value = "select app_users.* from app_users"
            +"inner join group_members on group_members.user_id = app_users.id"
            +"where group_members.group_id = id :id")
    fun findGroupMembers(id: UUID): Flux<AppUser>
}