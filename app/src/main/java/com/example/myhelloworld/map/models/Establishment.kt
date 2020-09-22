package com.example.myhelloworld.map.models

import com.google.android.gms.maps.model.LatLng

class Establishment {
    /**
     * Establishment name
     */
    public var name: String

    /**
     * Establishment location
     */
    public var location: LatLng

    /**
     * Type of this establishment
     */
    public var type: EstablishmentType

    constructor(name: String, location: LatLng, type: EstablishmentType) {
        this.name = name
        this.location = location
        this.type = type
    }

}