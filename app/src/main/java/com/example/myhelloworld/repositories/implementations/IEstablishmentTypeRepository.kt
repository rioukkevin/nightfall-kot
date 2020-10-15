package com.example.myhelloworld.repositories.implementations

import retrofit2.http.GET

interface IEstablishmentTypeRepository {

    @GET("/types-establishment")
    suspend fun getEstablishmentTypes()

}