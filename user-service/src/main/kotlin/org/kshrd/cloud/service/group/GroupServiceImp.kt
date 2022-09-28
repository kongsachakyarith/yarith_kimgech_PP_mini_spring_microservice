package org.kshrd.cloud.service.group

import org.kshrd.cloud.model.dto.AppUserDto
import org.kshrd.cloud.model.dto.GroupDto
import org.kshrd.cloud.model.dto.MemberDto
import org.kshrd.cloud.model.request.GroupRequest
import org.kshrd.cloud.model.request.MemberRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class GroupServiceImp(val groupRepository: GroupRepository) : GroupService {

    override fun findAll(): Flux<GroupDto> {
        return groupRepository.findAll().map { it.toDto() }
    }

    override fun findById(id: UUID): Mono<GroupDto> {
        return groupRepository.findById(id)
            .map { it.toDto() }
    }

    override fun createGroup(groupRequest: GroupRequest): Mono<GroupDto> {
        return groupRepository.save(groupRequest.toEntity())
            .map { it.toDto() }
    }

//    override fun findGroupMemberByGroupId(id: UUID): Mono<AppUserDto> {
//        return groupRepository.fin
//    }

//    override fun createGroupMember(memberRequest: MemberRequest): Mono<MemberDto> {
//        return groupRepository.save(memberRequest.toEntity()).map { it.toDto() }
//    }

}