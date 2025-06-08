package com.androidbc.feedboard.domain.model

data class UserResponse(
    val users: List<User>
)

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val image: String,
    val postImage: String,
    val company: Company,
    val address: Address,
    val caption: String,
    val headline: String,
    val joinedAt: String,
    val workMode: String,
    val skills: List<String>
)

data class Company(
    val name: String,
    val title: String
)

data class Address(
    val city: String,
    val state: String
)
