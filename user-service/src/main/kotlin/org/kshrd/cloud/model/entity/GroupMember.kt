package org.kshrd.cloud.model.entity

import nonapi.io.github.classgraph.json.Id
import org.kshrd.cloud.model.dto.MemberDto
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

@Table("group_members")
data class GroupMember (

    @Id
    @Column("group_id")
    val groupId: UUID,

    @Column("user_id")
    val userId: Int,

    @Column("added_by")
    val addedBy: Int,

    @Column("date_added")
    val dateAdded: LocalDateTime
        ){
    fun toDto() = MemberDto(
    groupId=groupId,
        userId=userId,
        addedBy=addedBy,
        dateAdded=dateAdded
    )
}