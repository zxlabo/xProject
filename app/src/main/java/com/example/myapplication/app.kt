package com.example.myapplication

import android.app.Application
import com.facebook.soloader.SoLoader

class app : Application() {
    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
    }
}