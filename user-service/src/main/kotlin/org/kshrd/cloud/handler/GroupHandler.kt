package org.kshrd.cloud.handler

import org.kshrd.cloud.model.dto.GroupDto
import org.kshrd.cloud.model.request.GroupRequest
import org.kshrd.cloud.service.group.GroupService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.UUID

@Component
class GroupHandler (val groupService: GroupService){

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


}