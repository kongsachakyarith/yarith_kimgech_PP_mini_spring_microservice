package org.kshrd.cloud.model.request

data class AppUserProfileRequest (
    val username: String,
    val profileImage: String,
    val firstName: String,
    val lastName: String
)