package com.example.faircorp.model

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiServices {

    val windowsApiService : WindowApiService by lazy {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
//                .baseUrl("https://dev-mind.fr/training/android/")
                .baseUrl("http://192.168.1.24:8080/api/")
                .build()
                .create(WindowApiService::class.java)
    }
}