package com.example.myhelloworld.repositories.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryFactory {
    val url = "http://localhost:3000"

    inline fun <reified TRepository> getRepository(): TRepository {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(TRepository::class.java)
    }
}