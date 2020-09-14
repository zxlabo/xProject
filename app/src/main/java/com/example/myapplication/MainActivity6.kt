package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.permission.tools.XActivityResult
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        tv.setOnClickListener {
            XActivityResult.create()
                .start(this, MainActivity7::class.java, 200)
                .onActivityResultCallback { i, i2, intent ->
                    Log.d("xone", "onCreate: --------MainActivity6")
                    setResult(100)
                    finish()
                }
        }
    }
}