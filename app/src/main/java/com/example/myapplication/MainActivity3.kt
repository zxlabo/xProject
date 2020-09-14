package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    private val a = arrayOfNulls<arraybean>(8)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        flow.referencedIds = intArrayOf(R.id.tv, R.id.tv3, R.id.tv1)

        bt02.setOnClickListener {
            group.visibility = View.VISIBLE
            tv3.text = mainview.childCount.toString()
        }
        bt01.setOnClickListener {
            group.visibility = View.GONE
        }
    }
}