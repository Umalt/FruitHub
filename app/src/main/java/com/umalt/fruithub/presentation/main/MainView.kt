package com.umalt.fruithub.presentation.main

import com.umalt.fruithub.presentation.base.BaseView

/**
 * Created by Umalt on 3/1/21
 */
interface MainView : BaseView {
    fun openScreen(fragmentTag: String)

    fun closeApp()
}