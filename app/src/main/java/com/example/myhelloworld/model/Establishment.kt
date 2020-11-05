package com.example.myhelloworld.model

import com.example.myhelloworld.map.models.Address

class Establishment {
    /**
     * Establishment name
     */
    var name: String

    /**
     * Establishment location
     */
    var address: Address

    /**
     * Type of this establishment
     */
    var establishment_type: EstablishmentType

    constructor(name: String, address: Address, type: EstablishmentType) {
        this.name = name
        this.address = address
        this.establishment_type = type
    }

}