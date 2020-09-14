package com.example.myapplication

import android.content.Context
import android.util.Log
import com.example.permission.tools.XActivityResult

class text {

    fun requse(cxt: Context) {
        XActivityResult.create()
            .start(cxt, MainActivity4::class.java, 100)
            .onActivityResultCallback { i, i2, intent ->
                Log.d("xone", "onCreate: --------MainActivity3")
            }
    }


}