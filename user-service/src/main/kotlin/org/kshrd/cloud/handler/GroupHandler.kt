package org.kshrd.cloud.handler

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.dto.GroupDto
import org.kshrd.cloud.model.dto.MemberDto
import org.kshrd.cloud.model.request.GroupRequest
import org.kshrd.cloud.model.request.MemberRequest
import org.kshrd.cloud.service.group.GroupService
import org.kshrd.cloud.service.groupmember.GroupMemberService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import java.util.UUID

@Component
class GroupHandler (val groupService: GroupService, val groupMemberService: GroupMemberService){

    fun getAllGroups(req: ServerRequest):Mono<ServerResponse>{
        return ServerResponse.ok().body(groupService.findAll(), GroupDto::class.java)
    }

    fun findById(req: ServerRequest): Mono<ServerResponse>{
        val groupId = UUID.fromString(req.pathVariable("id"))

        return ServerResponse.ok().body(groupService.findById(groupId), GroupDto::class.java)
    }

    fun createGroup(req: ServerRequest): Mono<ServerResponse>{
        return req.bodyToMono(GroupRequest::class.java)
            .flatMap { groupService.createGroup(it) }
            .flatMap { ServerResponse.ok().bodyValue(it) }
    }

    fun createMemberGroup(req: ServerRequest): Mono<ServerResponse>{
        val memberRequest = req.bodyToMono(MemberRequest::class.java)

//        val members = memberRequest.flatMap {
//            groupMemberService.createGroupMember(it)
//        }
        return ServerResponse.ok().body(
            memberRequest.flatMap { groupMemberService.createGroupMember(it) },MemberDto::class.java)
    }

    fun findGroupMember(req: ServerRequest): Mono<ServerResponse>{
        val groupId = UUID.fromString(req.pathVariable("id"))

        return ServerResponse.ok().body(groupMemberService.findMemberByGroupId(groupId), AppUserDto::class.java)
    }

}