package com.umalt.fruithub.di.component

import com.umalt.fruithub.di.module.AppModule
import com.umalt.fruithub.di.scope.AppScope
import com.umalt.fruithub.presentation.app.AppPresenter
import dagger.Subcomponent

/**
 * Created by Umalt on 2/27/21
 */
@AppScope
@Subcomponent(modules = [AppModule::class])
interface AppSubcomponent {
    fun inject(presenter: AppPresenter)
}