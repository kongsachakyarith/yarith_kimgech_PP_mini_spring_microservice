package org.kshrd.cloud.model.dto

import java.sql.Timestamp
import java.util.UUID

data class AppUserDto (
    val id: UUID,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val profileImage: String,
    val createdDate: Timestamp,
    val lastModified: Timestamp,
    val isEnabled: Boolean

        )