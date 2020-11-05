package com.example.myhelloworld.map.models


class Address {
    /**
     * Coordinates of the address
     */
    var coordinate: LatLng

    /**
     * Street number
     */
    var number: String

    /**
     * Street
     */
    var street: String

    /**
     * Zip code
     */
    var zipCode: String

    /**
     * City
     */
    var city: String


    constructor(coordinate: LatLng, number: String, street: String, zipCode: String, city: String) {
        this.coordinate = coordinate
        this.number = number
        this.street = street
        this.zipCode = zipCode
        this.city = city
    }

}