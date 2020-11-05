package com.example.myhelloworld.model

class EstablishmentType {
    /**
     * Establishment name
     */
    var name: String

    /**
     * Type color
     */
    var color: String

    /**
     * Value of the establishment type
     */
    var points: Int


    constructor(name: String, color: String, points: Int) {
        this.name = name
        this.color = color
        this.points = points
    }
}