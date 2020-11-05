package com.example.myhelloworld.repositories

import com.example.myhelloworld.dto.RankingResultDto
import com.example.myhelloworld.model.User
import com.example.myhelloworld.repositories.abstractions.Repository
import com.github.kittinunf.fuel.core.Method
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class UserRepository : Repository() {

    /**
     * Get a user by his id
     */
    fun getUser(userId: String, callback: (List<User>) -> Unit) {

        val type: Type = object : TypeToken<List<User>>() {}.type
        return this.request(Method.GET, "/users/${userId}", type, callback)
    }

    /**
     * Get the ranking
     */
    fun getRanking(period: String, callback: (RankingResultDto) -> Unit) {

        val type: Type = object : TypeToken<RankingResultDto>() {}.type
        return this.request(Method.GET, "/users/ranking?period=${period}", type, callback)
    }

}
