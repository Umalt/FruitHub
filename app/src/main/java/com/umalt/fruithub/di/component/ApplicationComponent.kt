package com.umalt.fruithub.di.component

import android.content.Context
import com.umalt.fruithub.di.module.AppModule
import com.umalt.fruithub.di.module.ApplicationModule
import com.umalt.fruithub.di.module.AuthModule
import com.umalt.fruithub.di.module.SplashModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Umalt on 2/27/21
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent {
    fun addAppSubcomponent(module: AppModule): AppSubcomponent
    fun addAuthSubcomponent(module: AuthModule): AuthSubcomponent
    fun addSplashSubcomponent(module: SplashModule): SplashSubcomponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }
}