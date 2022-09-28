package org.kshrd.cloud.model.request

import org.kshrd.cloud.model.entity.Task
import java.util.UUID

data class TaskRequest(
    val title: String,
    val description: String,
    val assignedTo: UUID?=null,
    val groupId: UUID?=null,
){
    fun toEntity()= Task(
        title = title,
        description = description,
        assignedTo = assignedTo,
        groupId = groupId,
        createBy = UUID.randomUUID()
    )
}
