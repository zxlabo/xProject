//package com.example.permission
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//
//class ResultFragment : Fragment() {
//
//    private var mListener: ((Int, Int, Intent?) -> Unit)? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        retainInstance = true
//    }
//
//    fun start(mClass: Class<*>, requestCode: Int, listener: (Int, Int, Intent?) -> Unit) {
//        this.mListener = listener
//        val intent = Intent(activity, mClass)
//        startActivityForResult(intent, requestCode)
//    }
//
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        mListener?.invoke(requestCode, resultCode, data)
//        mListener = null
//    }
//}