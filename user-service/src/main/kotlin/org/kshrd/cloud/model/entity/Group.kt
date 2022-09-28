package org.kshrd.cloud.model.entity

import nonapi.io.github.classgraph.json.Id
import org.kshrd.cloud.model.dto.GroupDto
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

@Table("groups")
data class Group (

    @Id
    @Column("id")
    val id: UUID? = null,

    @Column("group_name")
    val groupName: String,

    @Column("group_image")
    val groupImage: String,

    @Column("created_date")
    val createdDate: LocalDateTime
        ){
    fun toDto() = GroupDto(
        id = id!!,
        name =  groupName,
        image = groupImage,
        createdDate = createdDate
    )
}