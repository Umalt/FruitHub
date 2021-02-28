package com.umalt.fruithub.di.component

import com.umalt.fruithub.di.module.SplashModule
import com.umalt.fruithub.di.scope.SplashScope
import com.umalt.fruithub.presentation.splash.SplashPresenter
import dagger.Subcomponent

/**
 * Created by Umalt on 2/27/21
 */
@SplashScope
@Subcomponent(modules = [SplashModule::class])
interface SplashSubcomponent {
    fun inject(presenter: SplashPresenter)
}