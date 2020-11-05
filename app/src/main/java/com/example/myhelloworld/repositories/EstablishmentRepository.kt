package com.example.myhelloworld.repositories

import com.example.myhelloworld.model.Establishment
import com.example.myhelloworld.repositories.abstractions.Repository
import com.github.kittinunf.fuel.core.Method

class EstablishmentRepository : Repository() {
    fun getEstablishments(): List<Establishment> {

        return this.request(Method.GET, "/establishments")

    }
}
