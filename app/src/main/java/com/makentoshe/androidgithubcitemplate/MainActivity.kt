package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.data.LineData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Element(val net: String, val inf: String){
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager  = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(generateFakeValues())

        menuButton.setOnClickListener{
            drawer_layout.openDrawer(GravityCompat.START)
        }

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

    private fun generateFakeValues(): List<Element> {
        val values = mutableListOf<Element>()
        for (i in 0..100){
            values.add(Element("$i element","hi"))
        }
        return values
    }

    class Adapter(private val values: List<Element>): RecyclerView.Adapter<Adapter.ViewHolder>(){
        override fun getItemCount() = values.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.my_text_view, parent, false)
            return ViewHolder(itemView)
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var textView1: TextView? = null
            var textView2: TextView? = null
            init{
                textView1 = itemView?.findViewById(R.id.text_list_item1)
                textView2 = itemView?.findViewById(R.id.text_list_item2)
            }
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder?.textView1?.text = values[position].net
            holder?.textView2?.text = values[position].inf
        }
    }
}