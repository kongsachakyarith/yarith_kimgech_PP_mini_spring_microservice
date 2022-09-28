package org.kshrd.cloud.service.group

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.dto.GroupDto
import org.kshrd.cloud.model.dto.MemberDto
import org.kshrd.cloud.model.request.GroupRequest
import org.kshrd.cloud.model.request.MemberRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

interface GroupService {

    fun findAll(): Flux<GroupDto>

    fun findById(id: UUID):Mono<GroupDto>

    fun createGroup(groupRequest: GroupRequest): Mono<GroupDto>


}