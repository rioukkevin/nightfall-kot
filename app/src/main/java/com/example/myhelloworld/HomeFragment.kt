package com.example.myhelloworld

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fondesa.kpermissions.allGranted
import com.fondesa.kpermissions.extension.permissionsBuilder
import com.fondesa.kpermissions.extension.send
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry


private const val ARG_PSEUDO = "pseudo"
private const val ARG_SCORE = "score"

class HomeFragment : Fragment() {
    var pieDataSet: PieDataSet? = null
    var pieEntries: ArrayList<PieEntry>? = null
    var pieData: PieData? = null
    lateinit var userScorePieChart: PieChart

    companion object {
        fun newInstance(pseudo: String?, score: Float): HomeFragment? {
            val fragment = HomeFragment()
            val args = Bundle()
            // On passe les argument pour pouvoir les récupérer dans le onCreate
            args.putString(ARG_PSEUDO, pseudo)
            args.putFloat(ARG_SCORE, score)
            fragment.arguments = args
            return fragment
        }
    }

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
        return inflater.inflate(R.layout.fragment_home, container, false)

    }
}
