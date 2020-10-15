package com.example.myhelloworld.repositories.abstractions

import com.example.myhelloworld.model.Establishment
import retrofit2.http.GET

interface IEstablishmentRepository {

    @GET("/establishments")
    suspend fun getEstablishments(): List<Establishment>

}