package com.example.myhelloworld.repository

import com.example.myhelloworld.api.RetrofitInstance
import com.example.myhelloworld.model.Establishment
import com.example.myhelloworld.model.TypeEstablishment
import com.example.myhelloworld.model.User

class Repository {

    suspend fun getRanking() {
        return RetrofitInstance.api.getRanking()
    }

    suspend fun getUser() : User {
        return RetrofitInstance.api.getUser()
    }

    suspend fun getEstablishments() : Collection<Establishment> {
        return RetrofitInstance.api.getEstablishments()
    }

    suspend fun getTypesEstablishment() : Collection<TypeEstablishment>  {
        return RetrofitInstance.api.getTypesEstablishment()
    }

    suspend fun createTransaction() {
        return RetrofitInstance.api.createTransaction()
    }

}