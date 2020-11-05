package com.example.myhelloworld.repositories

import com.example.myhelloworld.model.Establishment
import com.example.myhelloworld.model.EstablishmentType
import com.example.myhelloworld.repositories.abstractions.Repository
import com.github.kittinunf.fuel.core.Method
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class EstablishmentTypeRepository : Repository() {

    /**
     * Get establishment types
     */
    fun getEstablishmentTypes(callback: (List<EstablishmentType>) -> Unit) {

        val type: Type = object : TypeToken<List<EstablishmentType>>() {}.type
        return this.request(Method.GET, "/types-establishment", type, callback)

    }
}
