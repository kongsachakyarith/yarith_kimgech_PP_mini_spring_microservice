package org.kshrd.cloud.model.entity

import org.kshrd.cloud.model.dto.TaskDto
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

@Table("tasks")
data class Task (
    @Id
    val id: UUID? =  null,

    @Column("title")
    val title: String,

    @Column("description")
    val description: String,

    @Column("create_by")
    val createBy: UUID?=null,

    @Column("assigned_to")
    val assignedTo: UUID?=null,

    @Column("group_id")
    val groupId: UUID?=null,


    @Column("created_date")
    val createdDate: LocalDateTime = LocalDateTime.now(),

    @Column("last_modified")
    val lastModified: LocalDateTime = LocalDateTime.now(),
) {
    fun toDto() = TaskDto(
        id = id!!,
        title = title,
        description = description,
        createBy = createBy,
        createdDate = createdDate,
        lastModified = lastModified,
        assignedTo = assignedTo,
        groupId = groupId,
    )
}