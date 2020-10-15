package com.example.myhelloworld.model

class User {

    private var firstname : String
    private var lastname : String
    private var email : String
    private var countPointsLastYear : Int
    private var countPointsLastMonth : Int

    constructor(firstnameParam : String, lastnameParam : String, emailParam : String, countPointsLastYearParam : Int, countPointsLastMonthParam : Int ) {
        firstname = firstnameParam
        lastname = lastnameParam
        email = emailParam
        countPointsLastYear = countPointsLastYearParam
        countPointsLastMonth = countPointsLastMonthParam
    }

}