package com.example.myhelloworld

import android.graphics.Color
import android.graphics.RectF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.renderer.PieChartRenderer
import com.github.mikephil.charting.utils.ColorTemplate


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
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Pseudo du joueur
        val textPseudo = view.findViewById<TextView>(R.id.user_pseudo)
        textPseudo.text = arguments?.get(ARG_PSEUDO).toString()

        // Socore du joueur
        val textScore = view.findViewById<TextView>(R.id.home_user_score_text)
        textScore.text = arguments?.get(ARG_SCORE).toString().toFloat().toInt().toString()

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
