package org.kshrd.cloud.service.groupmember

import org.kshrd.cloud.model.entity.GroupMember
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface GroupMemberRepository : ReactiveCrudRepository<GroupMember,UUID>{

}