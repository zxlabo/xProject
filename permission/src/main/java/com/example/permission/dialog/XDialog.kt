package com.example.permission.dialog

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class XDialog private constructor() {


    companion object {

        class Builder {
            private var mFragmentManager: FragmentManager? = null
            private var mDialog: BaseFragmentDialog? = null

            constructor(fragment: Fragment) {
                mFragmentManager = fragment.childFragmentManager
            }

            constructor(activity: FragmentActivity) {
                mFragmentManager == activity.supportFragmentManager
            }

            /**
             * 设置按下返回键是否关闭弹窗，默认为true
             *
             * @param isDismissOnBackPressed
             * @return
             */
            fun dismissOnBackPressed(isDismissOnBackPressed: Boolean): Builder {

                return this
            }

            /**
             * 设置点击弹窗外面是否关闭弹窗，默认为true
             *
             * @param isDismissOnTouchOutside
             * @return
             */
            fun dismissOnTouchOutside(isDismissOnTouchOutside: Boolean): Builder {

                return this
            }

            /**
             * 设置最大宽度，如果重写了弹窗的getMaxWidth，则以重写的为准
             *
             * @param maxWidth
             * @return
             */
            fun maxWidth(maxWidth: Int): Builder {
                return this
            }

            /**
             * 设置最大高度，如果重写了弹窗的getMaxHeight，则以重写的为准
             *
             * @param maxHeight
             * @return
             */
            fun maxHeight(maxHeight: Int): Builder {
                return this
            }
        }
    }
}