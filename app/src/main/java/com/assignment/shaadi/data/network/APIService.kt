package com.assignment.shaadi.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

/**
 * Created by Chetan on 26/09/20.
 */

interface APIService {
    @GET("?results=10")
    suspend fun getInvitations(): APIResponse

}

object RetrofitFactory {
    const val BASE_URL = "https://randomuser.me/api/"

    fun makeRetrofitService(): APIService {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build().create(APIService::class.java)
    }
}