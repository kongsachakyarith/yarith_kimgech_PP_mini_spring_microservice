package org.kshrd.demo.userservice.model.entity

import nonapi.io.github.classgraph.json.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp

@Table("groups")
data class Group (
    @Id
    val id: Long? = null,

    @Column("group_name")
    val groupName: String,

    @Column("group_image")
    val groupImage: String,

    @Column("created_date")
    val createdDate: Timestamp
        )