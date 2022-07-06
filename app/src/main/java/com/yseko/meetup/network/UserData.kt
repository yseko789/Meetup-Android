package com.yseko.meetup.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestUser(
    @Json(name = "email")
    val email: String,
    @Json(name = "username")
    val username: String,
    @Json(name = "password")
    val password: String
)

class ResponseUser (
    val username: String,
    val token: String
)