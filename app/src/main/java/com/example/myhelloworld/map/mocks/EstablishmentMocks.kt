package com.example.myhelloworld.map.mocks

import com.example.myhelloworld.map.models.Establishment
import com.google.android.gms.maps.model.LatLng

class EstablishmentMocks {
    companion object {
        val jamesJoyce = Establishment(
            "James Joyce",
            LatLng(47.47457504272461, -0.5471351742744446),
            EstablishmentTypeMocks.bar
        )

        val leHangarAMousse = Establishment(
            "Le Hangar à Mousses",
            LatLng(47.4697155, -0.6230436),
            EstablishmentTypeMocks.bar
        )

        val lhoirie = Establishment(
            "L'Hoirie",
            LatLng(47.4691433, -0.6184823),
            EstablishmentTypeMocks.restaurant
        )

        val laChapelle = Establishment(
            "La Chapelle",
            LatLng(47.4716384, -0.551046),
            EstablishmentTypeMocks.nightclub
        )

        val leCarre = Establishment(
            "Le Carré",
            LatLng(47.4732063, -0.553624),
            EstablishmentTypeMocks.nightclub
        )

        val establishments: ArrayList<Establishment> =
            arrayListOf(jamesJoyce, leHangarAMousse, laChapelle, lhoirie, leCarre)


    }


}