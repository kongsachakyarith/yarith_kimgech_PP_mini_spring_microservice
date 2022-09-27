package org.kshrd.cloud.model.request

import java.util.UUID

data class GroupMemberRequest (
    val groupId: UUID,
    val userId: UUID
        )
//{
//    fun toEntity
//}