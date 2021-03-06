package com.example.myhelloworld.model

class User {

    private var firstName: String
    private var lastName: String
    private var email: String
    private var countPointsLastYear: Int
    private var countPointsLastMonth: Int

    constructor(
        firstnameParam: String,
        lastnameParam: String,
        emailParam: String,
        countPointsLastYearParam: Int,
        countPointsLastMonthParam: Int
    ) {
        firstName = firstnameParam
        lastName = lastnameParam
        email = emailParam
        countPointsLastYear = countPointsLastYearParam
        countPointsLastMonth = countPointsLastMonthParam
    }

}