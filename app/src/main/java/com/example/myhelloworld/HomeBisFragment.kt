package com.example.myhelloworld

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

private const val ARG_PSEUDO = "pseudo"
private const val ARG_SCORE = "score"

class HomeBisFragment : Fragment() {
    var pieDataSet: PieDataSet? = null
    var pieEntries: ArrayList<PieEntry>? = null
    var pieData: PieData? = null
    lateinit var userMonthScorePieChart: PieChart
    lateinit var userYearScorePieChart: PieChart
    var maxScoreMonthValue : Int = 1000
    var maxScoreYearValue : Int = maxScoreMonthValue * 12
    var maxScoreMonth : String = maxScoreMonthValue.toString()
    var maxScoreYear : String = maxScoreYearValue.toString()

    companion object {
        fun newInstance(pseudo: String?, score: Float): HomeBisFragment? {
            val fragment = HomeBisFragment()
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

        val view = inflater.inflate(R.layout.fragment_home_bis, container, false)

        // Pseudo du joueur
        view.findViewById<TextView>(R.id.user_pseudo).text = arguments?.get(ARG_PSEUDO).toString()

        // Score du joueur pour le mois
        view.findViewById<TextView>(R.id.home_user_score_text_month).text = arguments?.get(ARG_SCORE).toString()

        // Score du joueur pour l'année
        view.findViewById<TextView>(R.id.home_user_score_text_year).text = "5000"

        // Score maximum
        view.findViewById<TextView>(R.id.home_user_score_text_month_max).text = maxScoreMonth
        view.findViewById<TextView>(R.id.home_user_score_text_year_max).text = maxScoreYear

        userMonthScorePieChart = view.findViewById<PieChart>(R.id.home_user_score_pie_chart_month)
        userMonthScorePieChart.legend.isEnabled = false // Désactive les légendes
        userMonthScorePieChart.data = buildPieChartScore(arguments?.get(ARG_SCORE).toString().toFloat(), maxScoreMonthValue.toFloat())

        userYearScorePieChart = view.findViewById<PieChart>(R.id.home_user_score_pie_chart_year)
        userYearScorePieChart.legend.isEnabled = false // Désactive les légendes
        userYearScorePieChart.data = buildPieChartScore(4600f, maxScoreYearValue.toFloat() )

        return view

    }

    private fun buildPieChartScore(score : Float, divisor : Float): PieData? {

        val entryScore = PieEntry(score, "")
        pieEntries = ArrayList()
        pieEntries!!.add(entryScore)

        val entryRestScore = PieEntry(divisor - score, "")
        pieEntries!!.add(entryRestScore)

        pieDataSet = PieDataSet(pieEntries, "")
        pieData = PieData(pieDataSet)
        pieData!!.setDrawValues(false)
        pieDataSet!!.setColors(Color.rgb(255, 166, 0), Color.argb(0.3f, 10f, 10f, 10f))

        return pieData;
    }
}
