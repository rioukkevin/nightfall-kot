package com.example.myhelloworld

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myhelloworld.map.mocks.EstablishmentMocks
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.ScaleBarOverlay
import org.osmdroid.views.overlay.compass.CompassOverlay
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay


class MapFragment : Fragment(), LocationListener {

    //Properties

    /**
     * View of the map
     */
    private lateinit var map: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Load map view
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        this.map = view.findViewById(R.id.poiMap)

        //Configure map
        this.configureMap()
//        val mapController: IMapController = this.mapView.getController()
//        mapController.setZoom(9.5)
//        val startPoint = GeoPoint(48.8583, 2.2944)
//        mapController.setCenter(startPoint)

        requestPermissionsIfNecessary(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE
            )
        )
        this.map.onResume()


        return view

    }


    override fun onResume() {
        super.onResume()
        this.map.onResume() //needed for compass, my location overlays, v6.0.0 and up
    }

    override fun onPause() {
        super.onPause()
        map.onPause() //needed for compass, my location overlays, v6.0.0 and up
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            R.integer.OSMDROID_REQUEST_CODE -> {
                //Ask refuse permissions
                val permissionsToRequest: ArrayList<String> = ArrayList()
                for (i in 0 until grantResults.size) {
                    permissionsToRequest.add(permissions[i])
                }
                if (permissionsToRequest.size > 0) {
                    ActivityCompat.requestPermissions(
                        this.requireActivity(),
                        permissionsToRequest.toArray(arrayOfNulls(0)),
                        R.integer.OSMDROID_REQUEST_CODE
                    )
                }
            }
        }


    }


    /**
     * Request persmission if not already done
     */
    private fun requestPermissionsIfNecessary(permissions: Array<String>) {
        val permissionsToRequest: ArrayList<String> = ArrayList()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(this.requireContext(), permission)
                != PackageManager.PERMISSION_GRANTED
            ) {
                // Permission is not granted
                permissionsToRequest.add(permission)
            }
        }
        if (permissionsToRequest.size > 0) {
            ActivityCompat.requestPermissions(
                this.requireActivity(),
                permissionsToRequest.toArray(arrayOfNulls(permissionsToRequest.size)),
                R.integer.OSMDROID_REQUEST_CODE
            )
        }
    }


    private fun configureMap() {

        //Add tile
        this.map.setTileSource(TileSourceFactory.MAPNIK)

        //Change user agent
        val configOsm = Configuration.getInstance()
        configOsm.userAgentValue = BuildConfig.APPLICATION_ID

        //Zoom button and zoom with fingers
        this.map.zoomController.setVisibility(CustomZoomButtonsController.Visibility.ALWAYS)
        this.map.zoomController.activate()
        this.map.setMultiTouchControls(true)

        //Add compass
        val compassOverlay =
            CompassOverlay(context, InternalCompassOrientationProvider(context), this.map)
        compassOverlay.enableCompass()
        this.map.overlays.add(compassOverlay)

        //Add rotation gestures
        val rotationGestureOverlay = RotationGestureOverlay(context, this.map)
        rotationGestureOverlay.setEnabled(true)
        this.map.setMultiTouchControls(true)
        this.map.overlays.add(rotationGestureOverlay)


        //Add markers
        EstablishmentMocks.establishments.forEach { estab ->
            val startPoint = GeoPoint(estab.location.latitude, estab.location.longitude)
            val marker = Marker(this.map)
            marker.title = estab.name
            marker.position = startPoint
            this.map.overlays.add(marker)
        }

        //Add scale bar
        val dm: DisplayMetrics = requireContext().resources.displayMetrics
        val scaleBarOverlay = ScaleBarOverlay(this.map)
        scaleBarOverlay.setCentred(true)
        scaleBarOverlay.setScaleBarOffset(dm.widthPixels / 2, 10)
        this.map.overlays.add(scaleBarOverlay)

        //Set position
        val locationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(context), this.map)
        locationOverlay.enableMyLocation()
        this.map.overlays.add(locationOverlay)

        this.map.controller.setZoom(15)
        this.map.controller.setCenter(GeoPoint(47.4667, -0.55))


    }

    override fun onLocationChanged(location: Location) {

    }

}