package org.kshrd.cloud.service.groupmember

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.dto.MemberDto
import org.kshrd.cloud.model.request.MemberRequest
import org.kshrd.cloud.service.appusers.AppUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class GroupMemberServiceImp(val groupMemberRepository: GroupMemberRepository, val appUserRepository: AppUserRepository): GroupMemberService {

    override fun createGroupMember(memberRequest: MemberRequest): Mono<MemberDto> {
        val userId = groupMemberRepository.findUserIdById(memberRequest.userId)
        val group = userId
            .flatMap {
                groupMemberRepository.save(memberRequest.toEntity(it))
            }.map { it.toDto() }
        return group
    }

    override fun findMemberByGroupId(id: UUID): Flux<AppUserDto> {
        return appUserRepository.findGroupMembers(id).map { it.toDto() }

    }
}