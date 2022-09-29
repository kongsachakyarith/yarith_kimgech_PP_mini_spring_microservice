package org.kshrd.cloud.service.groupmember

import org.kshrd.cloud.model.entity.GroupMember
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface GroupMemberRepository : ReactiveCrudRepository<GroupMember,UUID>{
    @Query(value = "select id from app_users where auth_id = :id")
    fun findUserIdById(id: UUID): Mono<Int>

//    @Query(value = "select app_users.* from app_users"
//            +"inner join group_members on group_members.user_id = app_users.id"
//            +"where group_members.group_id = id :id")
//    fun findGroupMembers(id: UUID): Flux<AppUser>
}