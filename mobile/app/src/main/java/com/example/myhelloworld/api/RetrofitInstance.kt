package com.example.myhelloworld.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://localhost::3000")
            .addConverterFactory( GsonConverterFactory.create() )
            .build()
    }

    val api : NodeApi by lazy {
        retrofit.create( NodeApi::class.java )
    }

}