package com.yseko.meetup.network

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "http://10.0.2.2:3000/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()



interface ExpressService {

    @POST("auth/register/")
    suspend fun registerUser(
        @Body user: RequestUser
    ): ResponseUser



    @GET("vendor/")
    suspend fun getAllVendors(
    ):ResponseVendors
}

object ExpressServiceApi{
    val retrofitService: ExpressService by lazy{
        retrofit.create(ExpressService::class.java)
    }
}