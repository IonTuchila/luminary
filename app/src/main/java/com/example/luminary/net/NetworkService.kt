package com.example.luminary.net

import com.example.luminary.net.response.UserResponse
import com.example.luminary.util.URL.BASE_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class NetworkService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(LuminaryApi::class.java)

    suspend fun getAllUsers(): UserResponse = withContext(Dispatchers.Default) {
        delay(1500)
        val result = apiService.getUsers(1, 15)
        result
    }

}

