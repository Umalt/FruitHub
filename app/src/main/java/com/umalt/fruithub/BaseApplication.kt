package com.umalt.fruithub

import android.app.Application
import com.facebook.stetho.Stetho
import com.umalt.fruithub.di.DIManager
import com.umalt.fruithub.di.component.DaggerApplicationComponent
import com.umalt.fruithub.utils.Utils

/**
 * Created by Umalt on 2/18/21
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DIManager.applicationComponent = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()

        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)

        Utils.init(this)
    }
}