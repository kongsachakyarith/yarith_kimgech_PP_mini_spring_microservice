package org.kshrd.cloud.model.request

import org.kshrd.cloud.model.entity.AppUser
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

data class AppUserRequest (
    val username: String,
    val email: String,
    val profileImage: String,
    val firstName: String,
    val lastName: String,
    val password: String
        ){
    fun toEntity()= AppUser(
       username = username,
       email = email,
       profileImage = profileImage,
       firstName = firstName,
       lastName = lastName,
       createdDate = LocalDateTime.now(),
        lastModified = LocalDateTime.now(),
        isEnabled = false,
        authId = UUID.randomUUID()
    )
}