package com.example.myhelloworld.repositories

import com.example.myhelloworld.model.EstablishmentType
import com.example.myhelloworld.repositories.abstractions.Repository
import com.github.kittinunf.fuel.core.Method

class EstablishmentTypeRepository : Repository() {

    /**
     * Get establishment types
     */
    fun getEstablishmentTypes(): List<EstablishmentType> {
        return this.request(Method.GET, "/types-establishment")

    }
}
