package org.kshrd.cloud.model.request

import java.util.UUID

data class MemberRequest (
    val groupId: UUID,
    val userId: UUID
        )
//{
//    fun toEntity
//}