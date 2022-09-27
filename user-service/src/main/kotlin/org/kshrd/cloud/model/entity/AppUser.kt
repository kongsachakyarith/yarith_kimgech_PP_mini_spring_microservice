package com.kshrd.demo.userservice.model.entity

import com.kshrd.demo.userservice.model.dto.AppUserDto
import nonapi.io.github.classgraph.json.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp
import java.util.UUID

@Table("app_users")
data class AppUser (
    @Id
    val id: UUID? = null,

    @Column("auth_id")
    val authId: UUID,

    @Column("email")
    val email: String,

    @Column("username")
    val username: String,

    @Column("first_name")
    val firstName: String,

    @Column("last_name")
    val lastName: String,

    @Column("profile_image")
    val profileImage: String,

    @Column("created_date")
    val createdDate: Timestamp,

    @Column("last_modified")
    val lastModified: Timestamp,

    @Column("is_enabled")
    val isEnabled: Boolean=false

    ){
    fun toDto() = AppUserDto(
        id = id!!,
        username = username,
        email= email,
        firstName=firstName,
        lastName=lastName,
        profileImage=profileImage,
        createdDate=createdDate,
        lastModified=lastModified,
        isEnabled=isEnabled
    )
}



