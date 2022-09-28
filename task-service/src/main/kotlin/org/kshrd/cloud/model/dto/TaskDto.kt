package org.kshrd.cloud.model.dto

import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

class TaskDto (
    val id: UUID,
    val title: String,
    val description: String,
    val createBy: UUID?=null,
    val assignedTo: UUID?=null,
    val groupId: UUID?=null,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val lastModified: LocalDateTime = LocalDateTime.now(),
)