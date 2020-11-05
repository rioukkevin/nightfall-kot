package com.example.myhelloworld.repositories.abstractions

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.core.Response
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

abstract class Repository {

    /**
     * Base API URL
     */
    //TODO: Get from conf file
    val baseUrl = "http://172.22.182.8:3000";


    /**
     * Deserialize the response to the type
     */
    protected fun <TType> deserialize(value: Response): TType {
        val type: Type = object : TypeToken<TType>() {}.type

        return Gson().fromJson<TType>(value.body().asString("application/json"), type)
    }

    /**
     * Request the api
     */
    protected fun <TResultType> request(
        method: Method,
        endpoint: String,
        body: String? = null
    ): TResultType {

        val request = Fuel.request(method, this.baseUrl.plus(endpoint))

        //Add body
        if (body !== null) {
            request.body(body)
        }

        val result = request.responseString().second

        return this.deserialize(result)
    }
}