package com.example.myhelloworld.repositories

import com.example.myhelloworld.model.EstablishmentType
import com.example.myhelloworld.repositories.abstractions.Repository
import com.github.kittinunf.fuel.core.Method

class TransactionRepository : Repository() {

    /**
     * Add a transaction
     */
    fun addTransaction(establishment_id: String): List<EstablishmentType> {
        return this.request(Method.POST, "/transactions/create/${establishment_id}")
    }
}
