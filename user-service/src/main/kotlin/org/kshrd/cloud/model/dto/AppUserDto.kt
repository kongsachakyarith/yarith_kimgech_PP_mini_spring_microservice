package com.kshrd.demo.userservice.model.dto

import jdk.jfr.Enabled
import java.sql.Timestamp
import java.util.TimeZone
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