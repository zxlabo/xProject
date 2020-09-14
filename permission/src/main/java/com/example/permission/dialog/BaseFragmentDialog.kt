package com.example.permission.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlin.properties.Delegates

abstract class BaseFragmentDialog : DialogFragment() {

    abstract fun initLayout(): Int
    abstract fun initView(rootView: View)

    protected var rootView: View? = null
    protected var mContext: Context by Delegates.notNull()
    protected var mDialog: Dialog? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        mDialog = super.onCreateDialog(savedInstanceState)
        mDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return mDialog!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        return rootView ?: inflater.inflate(initLayout(), container, false).apply {
            this@BaseFragmentDialog.rootView = this
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = setDismissOnBackPressed()
        mDialog?.setCanceledOnTouchOutside(setDismissOnTouchOutside())
        initView(view)
    }

    override fun onStart() {
        super.onStart()
        initDialogStatus(getDialogWindow())
    }

    open fun setDismissOnBackPressed(): Boolean = true

    open fun setDismissOnTouchOutside(): Boolean = true

    override fun onDestroyView() {
        super.onDestroyView()
        rootView = null
        mDialog = null
    }

    protected fun getDialogWindow(): Window? = mDialog?.window

    private fun initDialogStatus(window: Window?) {
        window?.let {
            it.decorView.setPadding(0, 0, 0, 0)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val params = it.attributes
            params.width = setDialogWidth()
            params.height = setDialogHeight()
            params.gravity = Gravity.CENTER
            params.windowAnimations = setDialogAnimations()
            it.attributes = params
        }
    }

    protected open fun setDialogAnimations(): Int = android.R.style.Animation_Dialog

    protected open fun setDialogWidth(): Int = 0

    protected open fun setDialogHeight(): Int = 0

    fun show(activity: FragmentActivity) {
        super.show(activity.supportFragmentManager, this.javaClass.simpleName)
    }

    fun show(fragment: Fragment) {
        super.show(fragment.childFragmentManager, this.javaClass.simpleName)
    }

}