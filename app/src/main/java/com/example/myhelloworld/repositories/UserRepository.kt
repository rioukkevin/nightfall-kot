package com.example.myhelloworld.repositories

import com.example.myhelloworld.dto.RankingResultDto
import com.example.myhelloworld.model.EstablishmentType
import com.example.myhelloworld.repositories.abstractions.Repository
import com.github.kittinunf.fuel.core.Method

class UserRepository : Repository() {

    /**
     * Get a user by his id
     */
    fun getUser(userId: String): List<EstablishmentType> {
        return this.request(Method.GET, "/users/${userId}")
    }

    /**
     * Get the ranking
     */
    fun getRanking(period: String): RankingResultDto {
        return this.request(Method.GET, "/users/ranking?period=${period}")
    }

}
