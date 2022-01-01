package com.example.graph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.series.PointsGraphSeries

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var graph =findViewById<GraphView>(R.id.gr1)
        var d :DataPoint

        val datap = arrayOf<DataPoint>(
            DP(1,0),
            DP(2,2),
        DP(3,3),
        )
        val datap1 = arrayOf<DataPoint>(
            DP(4,0),
            DP(5,2),
            DP(6,3),
        )
        var s:LineGraphSeries<DataPoint> = LineGraphSeries<DataPoint>(datap)
        var s1 = PointsGraphSeries<DataPoint>(datap1)
        graph.addSeries(s)
        graph.addSeries(s1)
    }


    fun DP(a: Int, b: Int): DataPoint {
        return DataPoint(a.toDouble(), b.toDouble())
    }


}