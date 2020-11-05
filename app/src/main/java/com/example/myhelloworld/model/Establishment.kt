package com.example.myhelloworld.model

import com.example.myhelloworld.map.models.LatLng

class Establishment {
    /**
     * Establishment name
     */
    var name: String

    /**
     * Establishment location
     */
    var location: LatLng

    /**
     * Type of this establishment
     */
    var type: EstablishmentType

    constructor(name: String, location: LatLng, type: EstablishmentType) {
        this.name = name
        this.location = location
        this.type = type
        this.location
    }

}