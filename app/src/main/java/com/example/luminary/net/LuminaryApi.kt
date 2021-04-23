package com.example.luminary.net

import com.example.luminary.net.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LuminaryApi {

    @GET("api/")
    suspend fun getUsers(@Query("page") page: Int, @Query("results") results: Int): UserResponse

}