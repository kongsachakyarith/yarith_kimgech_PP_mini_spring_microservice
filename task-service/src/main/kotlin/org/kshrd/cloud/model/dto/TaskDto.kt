package org.kshrd.cloud.model.dto

import org.kshrd.cloud.handler.AppUser
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

class TaskDto (
    val id: UUID,
    val title: String,
    val description: String,
    var createBy: AppUser?=null,
    var assignedTo: AppUser?=null,
    val groupId: UUID?=null,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val lastModified: LocalDateTime = LocalDateTime.now(),
)