package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.permission.tools.XActivityResult
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        tv.setOnClickListener {
//            XActivityResult1(this).start(MainActivity5::class.java, 100) { i, i2, intent ->
//                Log.d("xone", "onCreate: --------MainActivity4")
//                setResult(100)
//                finish()
//            }

            XActivityResult.create()
                .start(this, MainActivity5::class.java, 200)
                .onActivityResultCallback { i, i2, intent ->
                    Log.d("xone", "onCreate: --------MainActivity4")
                    setResult(100)
                    finish()
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("xone", "onActivityResult: --------MainActivity4")
    }
}