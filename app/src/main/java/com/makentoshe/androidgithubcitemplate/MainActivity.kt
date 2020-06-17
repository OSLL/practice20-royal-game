package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.mikephil.charting.data.LineData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        infoButton.setOnClickListener{
            val infoIntent = Intent(this, InfoActivity::class.java)
            startActivity(infoIntent)
        }

        playButton.setOnClickListener{
            pauseButton.animate().alpha(playButton.alpha).setDuration(200)
            playButton.animate().alpha(1 - playButton.alpha).setDuration(200)
        }

        /*val lineDataSets = arrayListOf(lineDataSet1, lineDataSet2)
        channelsChart.data = lineDataSets;
        channelsChart.invalidate()

        val revenueComp1 = arrayListOf(10000f, 20000f, 30000f, 40000f)
        val revenueComp2 = arrayListOf(12000f, 23000f, 35000f, 48000f)*/

    }

}
