package org.kshrd.cloud.service.groupmember

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.dto.MemberDto
import org.kshrd.cloud.model.request.MemberRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

interface GroupMemberService {

    fun createGroupMember(memberRequest: MemberRequest): Mono<MemberDto>

    fun findMemberByGroupId(id: UUID): Flux<AppUserDto>
}