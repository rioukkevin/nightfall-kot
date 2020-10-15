package com.example.myhelloworld.api

import retrofit2.http.GET
import retrofit2.http.POST

interface NodeApi {

    @GET("/users/ranking")
    suspend fun getRanking()

    @GET("/users/{user}")
    suspend fun getUser()

    @GET("/establishments")
    suspend fun getEstablishments()

    @GET("/types-establishment")
    suspend fun getTypesEstablishment()

    @POST("/transactions/create/{establishment_id}")
    suspend fun createTransaction()

}