package org.kshrd.cloud.model.request

import org.kshrd.cloud.model.entity.Group
import java.time.LocalDateTime

data class GroupRequest (
    val name: String,
    val image: String
        )
{
    fun toEntity() = Group(
        groupName = name,
        groupImage = image,
        createdDate = LocalDateTime.now()
    )
}