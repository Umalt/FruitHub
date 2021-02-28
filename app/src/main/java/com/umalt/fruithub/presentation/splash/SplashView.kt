package com.umalt.fruithub.presentation.splash

import com.umalt.fruithub.presentation.base.BaseView

/**
 * Created by Umalt on 2/27/21
 */
interface SplashView : BaseView {
    fun openNextScreen(isUserExist: Boolean)
}