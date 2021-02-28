package com.umalt.fruithub.di

import com.umalt.fruithub.di.component.AppSubcomponent
import com.umalt.fruithub.di.component.ApplicationComponent
import com.umalt.fruithub.di.component.AuthSubcomponent
import com.umalt.fruithub.di.component.SplashSubcomponent
import com.umalt.fruithub.di.module.AppModule
import com.umalt.fruithub.di.module.AuthModule
import com.umalt.fruithub.di.module.SplashModule

/**
 * Created by Umalt on 2/27/21
 */
object DIManager {
    lateinit var applicationComponent: ApplicationComponent

    private var appSubcomponent: AppSubcomponent? = null
    private var authSubcomponent: AuthSubcomponent? = null
    private var splashSubcomponent: SplashSubcomponent? = null

    fun getAppSubcomponent(): AppSubcomponent {
        if (appSubcomponent == null) {
            appSubcomponent = applicationComponent.addAppSubcomponent(AppModule)
        }
        return appSubcomponent ?: throw IllegalStateException("$appSubcomponent must not be null")
    }

    fun getAuthSubcomponent(): AuthSubcomponent {
        if (authSubcomponent == null) {
            authSubcomponent = applicationComponent.addAuthSubcomponent(AuthModule)
        }
        return authSubcomponent ?: throw IllegalStateException("$authSubcomponent must not be null")
    }

    fun getSplashSubcomponent(): SplashSubcomponent {
        if (splashSubcomponent == null) {
            splashSubcomponent = applicationComponent.addSplashSubcomponent(SplashModule)
        }
        return splashSubcomponent
            ?: throw IllegalStateException("$splashSubcomponent must not be null")
    }
}