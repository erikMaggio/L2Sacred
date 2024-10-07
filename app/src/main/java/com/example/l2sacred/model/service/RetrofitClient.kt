package com.example.l2sacred.model.service

import com.example.l2sacred.model.service.content.ClassGuidesService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val BASE_URL = "https://stoplight.io/mocks/l2-sacred/l2-sacred/525141024"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    private val apiService: ClassGuidesService by lazy {
        retrofit.create(ClassGuidesService::class.java)
    }

    fun getInstanceClass(): ClassGuidesService {
        return apiService
    }

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()
}
