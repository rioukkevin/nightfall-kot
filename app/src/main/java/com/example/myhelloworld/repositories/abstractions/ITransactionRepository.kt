package com.example.myhelloworld.repositories.abstractions

import retrofit2.http.POST
import retrofit2.http.Path

interface ITransactionRepository {

    @POST("/transactions/create/{establishment_id}")
    suspend fun createTransaction(@Path("establishment_id") establishment_id: Int): Void

}