package com.example.myhelloworld.repositories.abstractions

import com.example.myhelloworld.model.EstablishmentType
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface IEstablishmentTypeRepository {

    @GET("/types-establishment")
    fun getEstablishmentTypes(): Call<List<EstablishmentType>>

}