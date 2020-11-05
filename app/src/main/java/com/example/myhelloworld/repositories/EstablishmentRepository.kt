package com.example.myhelloworld.repositories

import com.example.myhelloworld.model.Establishment
import com.example.myhelloworld.repositories.abstractions.Repository
import com.github.kittinunf.fuel.core.Method
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class EstablishmentRepository : Repository() {
    fun getEstablishments(callback: (List<Establishment>) -> Unit) {

        val type: Type = object : TypeToken<List<Establishment>>() {}.type
        this.request(Method.GET, "/establishments", type, callback)

    }
}
