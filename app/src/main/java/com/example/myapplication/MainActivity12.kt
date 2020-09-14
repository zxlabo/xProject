package com.example.myapplication

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main12.*


class MainActivity12 : AppCompatActivity() {

    private var mSensorManager: SensorManager? = null
    private var mSensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)
        image_yun?.setAnimation("data.json")
        image_yun?.imageAssetsFolder = "images"
        image_yun?.progress = 0f
        image_yun?.loop(true)
        image_yun?.playAnimation()

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mSensor = mSensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        image.startAnimation(getAnimation())
    }


    override fun onResume() {
        super.onResume()
        mSensorManager?.registerListener(
            mSensorEventListener,
            mSensor,
            SensorManager.SENSOR_DELAY_GAME
        )
    }

    override fun onPause() {
        super.onPause()
        mSensorManager?.unregisterListener(mSensorEventListener)
    }


    var x = 0
    var translationX = 0f
    var y = 0
    var translationY = 0f
    var locationTime = 0L
    private val mSensorEventListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(sensorEvent: SensorEvent) {
            if (sensorEvent.accuracy != 0) {
                when (sensorEvent.sensor.type) {
                    Sensor.TYPE_ACCELEROMETER -> {
                        x = sensorEvent.values[0].toInt()
                        if (x != 0) {
                            if (x == 0) x = 1
                            if (x > 2) x = 2
                            if (x < 0 && x > -2) x = -1
                            if (x < -2) x = -2
                            translationX = image.translationX - x * 2.5f
                            if (translationX > image_model.width) {
                                translationX = image_model.width.toFloat()
                            } else if (translationX < -image_model.width) {
                                translationX = -image_model.width.toFloat()
                            }
                            image.translationX = translationX
                            image_yun.translationX = translationX / 2
                        }

                        y = sensorEvent.values[2].toInt() - 5
                        if (y != 0) {
                            if (y == 1) y = 1
                            if (y > 2) y = 2
                            if (y < 0 && y > -2) y = -1
                            if (y < -2) y = -2
                            translationY = image.translationY - y * 2.5f
                            if (translationY > image_model.width) {
                                translationY = image_model.width.toFloat()
                            } else if (translationY < -image_model.width) {
                                translationY = -image_model.width.toFloat()
                            }
                            image.translationY = translationY
                            image_yun.translationY = translationY / 2
                        }


//                        if (System.currentTimeMillis() - locationTime > 2000) {

//                        Log.d(
//                            "xone",
//                            "onSensorChanged: x = ${sensorEvent.values[0]}   y = $y  z = $z"
//                        )
//
//                        if (sensorEvent.values[0] > 0.5) {
//                            x += image.translationX
//                            if (x > image_model.width) x = image_model.width.toFloat()
//                        } else if (sensorEvent.values[0] < -0.5) {
//                            x -= image.translationX
//                            if (x < image_model.width) x = -image_model.width.toFloat()
//                        }
//
//                        image.translationX = x
//                        image.translationY = y
//
//                        image_yun.translationX = x
//                        image_yun.translationY = y

                        locationTime = System.currentTimeMillis()
//                        }


                    }
                }
            }
        }

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

        }
    }


    private fun getAnimation(): Animation {
        val animation = MAnimation()
        animation.duration = 60 * 60 * 24
        animation.repeatMode = Animation.REVERSE
        animation.repeatCount = Animation.INFINITE
        return animation
    }


    inner class MAnimation : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
//            Log.d("xone1", "applyTransformation: $interpolatedTime")
        }
    }
}