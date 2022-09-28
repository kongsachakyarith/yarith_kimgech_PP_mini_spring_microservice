package org.kshrd.cloud.model.entity

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

@Table("group_members")
data class GroupMember (
    @Column("group_id")
    val groupId: UUID,

    @Column("user_id")
    val userId: Int,

    @Column("added_by")
    val addedBy: Int,

    @Column("date_added")
    val dateAdded: LocalDateTime
        )