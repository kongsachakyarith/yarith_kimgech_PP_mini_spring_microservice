package com.kshrd.demo.userservice.model.request

import com.kshrd.demo.userservice.model.entity.AppUser

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