package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Matrix
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main10.*


@SuppressLint("ServiceCast")
class MainActivity10 : AppCompatActivity() {

    private var mSensorManager: SensorManager? = null
    private var mSensor: Sensor? = null
    val imageMatrix = Matrix()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mSensor = mSensorManager?.getDefaultSensor(Sensor.TYPE_ORIENTATION)

//        try {
//            val open: InputStream = resources.assets.open("im01.png")
//            val bitmap = BitmapFactory.decodeStream(open)
//            image.setImageBitmap(bitmap)
//
//            val open1: InputStream = resources.assets.open("im0.png")
//            val bitmap1 = BitmapFactory.decodeStream(open1)
//            image_yun.setImageBitmap(bitmap1)
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//
//        imageMatrix.postScale(1.5f, 1.5f, 0.5f, 0.5f)
//        imageMatrix.postTranslate(0f, 0f)
//        image.imageMatrix = imageMatrix
//        image.invalidate()
//
//        image_yun.imageMatrix = imageMatrix
//        image_yun.invalidate()

//        image.startAnimation(getAnimation())
        image.post {
            Log.d("xone", "onCreate: ----${image.width}")
        }
    }

    override fun onResume() {
        super.onResume()
        mSensorManager?.registerListener(
            mSensorEventListener,
            mSensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onPause() {
        super.onPause()
        mSensorManager?.unregisterListener(mSensorEventListener)
    }


    var x = 0f
    var y = 0f
    var loctionTime = 0L
    private val mSensorEventListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(sensorEvent: SensorEvent) {
            if (sensorEvent.accuracy != 0) {
                when (sensorEvent.sensor.type) {
                    Sensor.TYPE_ORIENTATION -> {
                        x = sensorEvent.values[1] * 3
                        y = sensorEvent.values[2] * 3

                        if (System.currentTimeMillis() - loctionTime > 20){
                            if (-y > 0) {
                                if (-y > image_model.width.toFloat())
                                    y = -image_model.width.toFloat()
                            } else {
                                if (-y < -image_model.width.toFloat())
                                    y = image_model.width.toFloat()
                            }

                            image.translationX = -y
                            image.translationY = -x

                            image_yun.translationX = -y / 2
                            image_yun.translationY = -x / 2

                            loctionTime = System.currentTimeMillis()
                        }
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
//            imageMatrix.reset()
//            imageMatrix.postScale(1.5f, 1.5f, 0.5f, 0.5f)

            if (-y > 0) {
                if (-y > image_model.width.toFloat())
                    y = -image_model.width.toFloat()
            } else {
                if (-y < -image_model.width.toFloat())
                    y = image_model.width.toFloat()
            }

            image.translationX = -y
            image.translationY = -x

            image_yun.translationX = -y / 2
            image_yun.translationY = -x / 2


//            if (-x > 0) {
//                if (-x > image_model.width.toFloat())
//                    x = -image_model.width.toFloat()
//            } else {
//                if (-x < -image_model.width.toFloat())
//                    x = image_model.width.toFloat()
//            }

//            imageMatrix.preTranslate(-y, -x)
//            image!!.imageMatrix = imageMatrix
//            image.invalidate()
        }
    }
}