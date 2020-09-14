package com.example.myapplication

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener
import com.google.vr.sdk.widgets.pano.VrPanoramaView
import kotlinx.android.synthetic.main.activity_main9.*


class MainActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)
        initVrPaNormalView()
    }

    private fun initVrPaNormalView() {
        val paNormalOptions = VrPanoramaView.Options()
        paNormalOptions.inputType = VrPanoramaView.Options.TYPE_MONO
        mVrPanoramaView.setFullscreenButtonEnabled(false) //隐藏全屏模式按钮
        mVrPanoramaView.setInfoButtonEnabled(false) //设置隐藏最左边信息的按钮
        mVrPanoramaView.setStereoModeButtonEnabled(false) //设置隐藏立体模型的按钮
        mVrPanoramaView.setEventListener(ActivityEventListener()) //设置监听
        //加载本地的图片源
        mVrPanoramaView.loadImageFromBitmap(
            BitmapFactory.decodeResource(
                resources,
                R.mipmap.mmm
            ), paNormalOptions
        )
        //设置网络图片源
//        panoWidgetView.loadImageFromByteArray();
    }

    private class ActivityEventListener : VrPanoramaEventListener() {
        override fun onLoadSuccess() { //图片加载成功
        }

        override fun onLoadError(errorMessage: String) { //图片加载失败
        }

        override fun onClick() { //当我们点击了VrPanoramaView 时候触发            super.onClick();
        }

        override fun onDisplayModeChanged(newDisplayMode: Int) {
            super.onDisplayModeChanged(newDisplayMode)
        }
    }
}