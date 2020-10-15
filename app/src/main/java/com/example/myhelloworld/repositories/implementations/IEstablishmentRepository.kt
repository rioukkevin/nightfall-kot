package com.example.myhelloworld.repositories.implementations

import retrofit2.http.GET

interface IEstablishmentRepository {

    @GET("/establishments")
    suspend fun getEstablishments()

}