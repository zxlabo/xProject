//package com.example.permission
//
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.content.Context
//import android.content.Intent
//import android.os.Build
//import android.os.Bundle
//import android.util.Log
//import android.view.WindowManager
//import androidx.annotation.RequiresApi
//
//class XPermission1 private constructor(ctx: Context) {
//
//    private var mContext: Context? = null
//
//    init {
//        this.mContext = ctx
//    }
//
//    companion object {
//
//        private var sInstance: XPermission1? = null
//
//        fun create(ctx: Context): XPermission1 {
//            if (null == sInstance) sInstance = XPermission1(ctx)
//            return sInstance!!
//        }
//    }
//
//    @SuppressLint("WrongConstant")
//    fun prepare(@PermissionConstants.Permission vararg permission: String) {
//        if (permission == null) return
//        val per = PermissionConstants.getPermissions(permission[0])
//        Log.d("xone", "prepare: $per")
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    class PermissionActivity : Activity() {
//
//        companion object {
//            private const val TYPE = "TYPE"
//            const val TYPE_RUNTIME = 0x01
//            const val TYPE_WRITE_SETTINGS = 0x02
//            const val TYPE_DRAW_OVERLAYS = 0x03
//
//            fun start(context: Context, type: Int) {
//                val starter = Intent(context, PermissionActivity::class.java)
//                starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                starter.putExtra(TYPE, type)
//                context.startActivity(starter)
//            }
//        }
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            window.addFlags(
//                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
//                        or WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
//                        or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//            )
//            window.attributes.alpha = 0f
//            val byteExtra = intent.getIntExtra(TYPE, TYPE_RUNTIME)
//            if (byteExtra == TYPE_RUNTIME) {
//                if (sInstance == null) {
//                    super.onCreate(savedInstanceState)
//                    Log.e("XPermission", "request permissions failed")
//                    finish()
//                    return
//                }
//                if (sInstance!!.mThemeCallback != null) {
//                    sInstance!!.mThemeCallback!!.onActivityCreate(this)
//                }
//                super.onCreate(savedInstanceState)
//                if (sInstance!!.rationale(this)) {
//                    finish()
//                    return
//                }
//                if (sInstance!!.mPermissionsRequest != null) {
//                    val size = sInstance!!.mPermissionsRequest!!.size
//                    if (size <= 0) {
//                        finish()
//                        return
//                    }
//                    requestPermissions(sInstance!!.mPermissionsRequest!!.toTypedArray(), 1)
//                }
//            } else if (byteExtra == TYPE_WRITE_SETTINGS) {
//                super.onCreate(savedInstanceState)
//                sInstance!!.startWriteSettingsActivity(this, TYPE_WRITE_SETTINGS)
//            } else if (byteExtra == TYPE_DRAW_OVERLAYS) {
//                super.onCreate(savedInstanceState)
//                sInstance!!.startOverlayPermissionActivity(this, XPermission.PermissionActivity.TYPE_DRAW_OVERLAYS)
//            }
//        }
//    }
//
//}