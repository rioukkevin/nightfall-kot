package com.example.myhelloworld

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myhelloworld.model.EstablishmentType
import com.example.myhelloworld.repositories.abstractions.IEstablishmentTypeRepository
import com.example.myhelloworld.repositories.config.RepositoryFactory
import com.fondesa.kpermissions.allGranted
import com.fondesa.kpermissions.extension.permissionsBuilder
import com.fondesa.kpermissions.extension.send
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Ask for permission
        permissionsBuilder(Manifest.permission.CAMERA, Manifest.permission.INTERNET).build()
            .send { result ->
                // Handle the result, for example check if all the requested permissions are granted.
                if (!result.allGranted()) {
                    // All the permissions are granted.
                    Toast.makeText(
                        requireActivity(),
                        "Vous n'avez pas accepté les droits, le QR Code ne fonctionnera pas",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        //Test
        val repo = RepositoryFactory().getRepository<IEstablishmentTypeRepository>()
        val estabCall = repo.getEstablishmentTypes()
        estabCall.enqueue(object : Callback<List<EstablishmentType>> {
            override fun onResponse(
                call: Call<List<EstablishmentType>>,
                response: Response<List<EstablishmentType>>
            ) {
                val myItem: List<EstablishmentType>? = response.body()
            }

            override fun onFailure(call: Call<List<EstablishmentType>>?, t: Throwable?) {
                //Handle failure
                val td = t
            }
        })

        return inflater.inflate(R.layout.fragment_home, container, false)

    }
}
