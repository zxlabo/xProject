package com.example.permission.dialog

import android.view.View
import com.example.permission.R
import kotlinx.android.synthetic.main.dialog_fragment_use_demo.*


class MyDialog : CenterDialog() {

    override fun initLayout(): Int = R.layout.dialog_fragment_use_demo

    override fun initView(rootView: View) {

        bt.setOnClickListener {
            dismiss()
        }
    }


}