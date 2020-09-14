package com.example.permission.dialog

import android.view.WindowManager

abstract class CenterDialog : BaseFragmentDialog() {

    override fun setDialogHeight(): Int {
        return WindowManager.LayoutParams.WRAP_CONTENT
    }

    override fun setDialogWidth(): Int {
        return (XDialogUtils.getWindowWidth(mContext) * 0.75f).toInt()
    }

    override fun setDismissOnTouchOutside(): Boolean {
        return false
    }
}