package com.example.myhelloworld.repositories

import com.example.myhelloworld.repositories.abstractions.Repository
import com.github.kittinunf.fuel.core.Method

class TransactionRepository : Repository() {

    /**
     * Add a transaction
     */
    fun addTransaction(
        establishment_id: String
    ) {
        return this.request<Void>(
            Method.POST,
            "/transactions/create/${establishment_id}",
            null,
            null
        )
    }
}
