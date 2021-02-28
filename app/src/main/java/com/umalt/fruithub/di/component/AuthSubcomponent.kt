package com.umalt.fruithub.di.component

import com.umalt.fruithub.di.module.AuthModule
import com.umalt.fruithub.di.scope.AuthScope
import com.umalt.fruithub.presentation.auth.AuthPresenter
import dagger.Subcomponent

/**
 * Created by Umalt on 2/27/21
 */
@AuthScope
@Subcomponent(modules = [AuthModule::class])
interface AuthSubcomponent {
    fun inject(presenter: AuthPresenter)
}