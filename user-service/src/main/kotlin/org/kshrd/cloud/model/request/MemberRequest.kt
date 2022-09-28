package org.kshrd.cloud.model.request

import org.kshrd.cloud.model.entity.GroupMember
import java.time.LocalDateTime
import java.util.UUID

data class MemberRequest (
    val groupId: UUID,
    val userId: UUID
        )
{
    fun toEntity(id : Int) = GroupMember(
        groupId = groupId,
        userId = id,
        addedBy = id,
        dateAdded = LocalDateTime.now()
    )
}