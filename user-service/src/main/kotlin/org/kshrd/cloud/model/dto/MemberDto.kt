package org.kshrd.cloud.model.dto

import java.time.LocalDateTime
import java.util.UUID

data class MemberDto (
    val groupId: UUID,
    val userId: Int,
    val addedBy: Int,
    val dateAdded: LocalDateTime
        )