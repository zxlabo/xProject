package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.permission.tools.XActivityResult
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        tv.setOnClickListener {
            XActivityResult.create()
                .start(this, MainActivity6::class.java, 200)
                .onActivityResultCallback { i, i2, intent ->
                    Log.d("xone", "onCreate: --------MainActivity5")
                    setResult(100)
                    finish()
                }
        }
    }
}