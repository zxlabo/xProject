package com.example.permission.dialog

import android.view.WindowManager

abstract class FullDialog : BaseFragmentDialog() {

    override fun setDialogAnimations(): Int {
        return android.R.style.Animation_InputMethod
    }

    override fun setDialogHeight(): Int {
        return WindowManager.LayoutParams.MATCH_PARENT
    }

    override fun setDialogWidth(): Int {
        return WindowManager.LayoutParams.MATCH_PARENT
    }
}