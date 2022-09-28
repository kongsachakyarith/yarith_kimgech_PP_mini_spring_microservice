package org.kshrd.cloud.model.request

data class AppUserRequest (
    val username: String,
    val email: String,
    val profileImage: String,
    val firstName: String,
    val lastName: String,
    val password: String
        ){
//    fun toEntity()=AppUser(
//
//    )
}