package com.yseko.meetup.network

class ResponseVendors(
    val vendors: Array<ResponseVendor>
)

class ResponseVendor(
    val _id: String,
    val name: String,
    val number: String,
    val peopleCurrent: Int,
    val peopleNeeded: Int,
    val description: String,
    val time: String,
    val location: String,
    val createdBy: String
)