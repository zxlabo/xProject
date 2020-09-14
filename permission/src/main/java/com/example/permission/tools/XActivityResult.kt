package com.example.permission.tools

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import java.util.*

class XActivityResult private constructor() {
    private var mClass: Class<*>? = null
    private val mListenerStack: Stack<((Int, Int, Intent?) -> Unit)?> by lazy { Stack<((Int, Int, Intent?) -> Unit)?>() }
    private var initNun = 0
    private var callBackNum = 0

    companion object {
        private var mInstance: XActivityResult? = null

        fun create(): XActivityResult {
            if (mInstance == null) mInstance = XActivityResult()
            return mInstance!!
        }
    }

    fun start(context: Context, mClass: Class<*>, requestCode: Int): XActivityResult {
        this.mClass = mClass
        XActivityResultActivity.start(context, requestCode)
        ++initNun
        return this
    }

    private fun startActivityForResult(activity: Activity, requestCode: Int) {
        val intent = Intent(activity, mClass)
        activity.startActivityForResult(intent, requestCode)
    }

    fun onActivityResultCallback(mListener: ((Int, Int, Intent?) -> Unit)) {
        mListenerStack.add(mListener)
        ++callBackNum
    }

    private fun resultCallback(requestCode: Int, resultCode: Int, data: Intent?) {
        if (initNun != callBackNum)
            throw Exception("your must be comply start() and onActivityResultCallback(),initNun and callBackNum must be same")
        if (mListenerStack.size == 0) return
        var mListener = mListenerStack.pop()
        mListener?.invoke(requestCode, resultCode, data)
        --initNun
        --callBackNum
        mListener = null
    }

    class XActivityResultActivity : Activity() {

        companion object {
            private const val requestCodeKey = "requestCodeKey"

            fun start(context: Context, requestCode: Int) {
                val starter = Intent(context, XActivityResultActivity::class.java)
                starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                starter.putExtra(requestCodeKey, requestCode)
                context.startActivity(starter)
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        or WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                        or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            window.attributes.alpha = 0f
            super.onCreate(savedInstanceState)
            if (null == mInstance) {
                finish()
                return
            }
            val requestCode = intent.getIntExtra(requestCodeKey, -0x00)
            mInstance?.startActivityForResult(this, requestCode)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            mInstance?.resultCallback(requestCode, resultCode, data)
            finish()
        }
    }
}