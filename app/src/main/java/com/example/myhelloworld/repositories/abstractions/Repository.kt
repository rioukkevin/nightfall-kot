package com.example.myhelloworld.repositories.abstractions

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.core.Response
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import kotlin.concurrent.thread

abstract class Repository {

    /**
     * Base API URL
     */
    //TODO: Get from conf file
    val baseUrl = "http://172.22.182.8:3000";


    /**
     * Deserialize the response to the type
     */
    protected fun <TType> deserialize(response: Response, type: Type?): TType {

        var json = String(response.data, Charsets.UTF_8)
        //Type in which deserialize
        return GsonBuilder().create().fromJson(json, type)
    }

    /**
     * Request the api
     */
    protected fun <TType> request(
        method: Method,
        endpoint: String,
        type: Type?,
        body: String? = null,
        callback: ((result: TType) -> Unit)?
    ) {

        thread {
            val request = Fuel.request(method, this.baseUrl.plus(endpoint))

            //Add body
            if (body !== null) {
                request.body(body)
            }

            //Get result
            var result = request.responseString()

            //Launch callback
            if (result.third.component2() === null && callback !== null) {

                //Get result and launch callback
                var resultValue = this.deserialize<TType>(result.second, type)
                callback(resultValue)
            }
        }

    }

    /**
     * Request the api
     */
    protected fun <TResultType> request(
        method: Method,
        endpoint: String,
        type: Type?,
        callback: ((result: TResultType) -> Unit)?
    ) {

        this.request(method, endpoint, type,null, callback)
    }
}