package org.kshrd.cloud.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("task_status")
class TaskStatus (

    @Id
    val id : Long? = null,

    @Column("name")
    val name : String
)