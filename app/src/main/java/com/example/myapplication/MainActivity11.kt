package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Text
import com.facebook.soloader.SoLoader

class MainActivity11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val  context  =  ComponentContext(this)

       val component = Text.create(context)
            .text("Hello World")
            .textSizeDip(50F)
            .build()

        setContentView(LithoView.create(context, component));

//        val c = ComponentContext(this)
//
//        val component2 = MainLithoView.create(c).color(Color.BLUE).title("这是一个Title").build()
////
////        val component = MainLithoViewSpec.onCreateLayout(c, Color.BLUE, "这是一个Title")
////        // 这里不在使用xml，使用 Litho的Component
//        setContentView(LithoView.create(c, component2))

    }
}