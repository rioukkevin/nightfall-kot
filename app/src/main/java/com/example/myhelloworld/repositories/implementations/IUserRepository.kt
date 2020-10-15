package com.example.myhelloworld.repositories.implementations

import retrofit2.http.GET
import retrofit2.http.Path

interface IUserRepository {

    @GET("/users/ranking")
    suspend fun getRanking()

    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int)

}