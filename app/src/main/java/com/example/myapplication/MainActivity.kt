package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val controller = Navigation.findNavController(this, R.id.fragment)
//        NavigationUI.setupActionBarWithNavController(this, controller)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val controller = Navigation.findNavController(this, R.id.fragment)
//        return controller.navigateUp()
//    }
}