package com.example.permission

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class XActivityResult1 {

    companion object {
        const val TAG = "ActivityResult"
    }

    @Volatile
    private var mFragment: ResultFragment? = null

    constructor(activity: FragmentActivity) {
        mFragment = getInstance(activity.supportFragmentManager)
    }

    constructor(fragment: Fragment) {
        mFragment = getInstance(fragment.childFragmentManager)
    }

    private fun getInstance(fragmentManager: FragmentManager) =
        mFragment ?: synchronized(this) {
            mFragment
                ?: if (fragmentManager.findFragmentByTag(TAG) == null) ResultFragment().run {
                    fragmentManager.beginTransaction().add(this, TAG).commitNow()
                    this
                } else fragmentManager.findFragmentByTag(TAG) as ResultFragment
        }

    fun start(mClass: Class<*>, requestCode: Int, listener: (Int, Int, Intent?) -> Unit) {
        mFragment?.start(mClass, requestCode, listener)
    }

    class ResultFragment : Fragment() {

        private var mListener: ((Int, Int, Intent?) -> Unit)? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            retainInstance = true
        }

        fun start(mClass: Class<*>, requestCode: Int, listener: (Int, Int, Intent?) -> Unit) {
            this.mListener = listener
            val intent = Intent(activity, mClass)
            startActivityForResult(intent, requestCode)
        }


        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            mListener?.invoke(requestCode, resultCode, data)
            mListener = null
        }
    }
}