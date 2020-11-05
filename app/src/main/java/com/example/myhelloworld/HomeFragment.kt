package com.example.myhelloworld

import android.graphics.Color
import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlin.reflect.KFunction1

import com.fondesa.kpermissions.allGranted
import com.fondesa.kpermissions.extension.permissionsBuilder
import com.fondesa.kpermissions.extension.send




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
        permissionsBuilder(Manifest.permission.CAMERA).build().send { result ->
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

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Pseudo du joueur
        val textPseudo = view.findViewById<TextView>(R.id.user_pseudo)
        textPseudo.text = arguments?.get(ARG_PSEUDO).toString()

        // Socore du joueur
        val textScore = view.findViewById<TextView>(R.id.home_user_score_text)
        textScore.text = arguments?.get(ARG_SCORE).toString().toFloat().toInt().toString()

        // Bonton d'information
        val infoI = view.findViewById<ImageView>(R.id.home_info_i)
        infoI.setOnClickListener{
            val intent = Intent(context, PopUpWindow::class.java)
            intent.putExtra("popuptitle", "Error")
            intent.putExtra("popuptext", "Sorry, that email address is already used!")
            intent.putExtra("popupbtn", "OK")
            intent.putExtra("darkstatusbar", false)
            startActivity(intent)
        }

        // Score maximum
        val textScoreMax = view.findViewById<TextView>(R.id.home_user_score_text_max)
        textScoreMax.text = "1000"


        userScorePieChart = view.findViewById<PieChart>(R.id.home_user_score_pie_chart)

        pieEntries = ArrayList()

        val score = arguments?.get(ARG_SCORE).toString().toFloat()

        val entryScore = PieEntry(score, "")
        pieEntries!!.add(entryScore)

        val entryRestScore = PieEntry(1000f - score, "")
        pieEntries!!.add(entryRestScore)

        userScorePieChart.legend.isEnabled = false // Désactive les légendes

        pieDataSet = PieDataSet(pieEntries, "")
        pieData = PieData(pieDataSet)
        pieData!!.setDrawValues(false)
        userScorePieChart.data = pieData
        pieDataSet!!.setColors(Color.rgb(255, 166, 0), Color.argb(0.3f, 10f, 10f, 10f))

        return view

    }
}
