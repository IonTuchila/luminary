package com.example.luminary.net

import android.database.Observable
import com.example.luminary.net.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface LuminaryApi {

    @GET("api/")
    fun getUsers(@Query("page") page : Int, @Query("results") results : Int) : io.reactivex.Observable<UserResponse>

}