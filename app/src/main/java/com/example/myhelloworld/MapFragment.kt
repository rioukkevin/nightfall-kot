package com.example.myhelloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myhelloworld.map.exceptions.GoogleMapLoadingException
import com.example.myhelloworld.map.mocks.EstablishmentMocks
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    //Properties
    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)

    }

    /**
     * Called when the map is ready
     */
    override fun onMapReady(map: GoogleMap?) {
        if (map === null) throw GoogleMapLoadingException()
        this.map = map

        EstablishmentMocks
            .establishments
            .forEach { estab ->
                this.map.addMarker(MarkerOptions().position(estab.location))
            }


    }
}
