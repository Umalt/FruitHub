package com.umalt.fruithub.di.module

import android.content.Context
import android.content.SharedPreferences
import com.umalt.database.db.RoomDatabase
import com.umalt.fruithub.BuildConfig
import com.umalt.fruithub.utils.FRUIT_HUB_PREFS_NAME
import com.umalt.network.ApiService
import com.umalt.network.ApiServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Umalt on 2/27/21
 */
@Module
object ApplicationModule {
    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            FRUIT_HUB_PREFS_NAME,
            Context.MODE_PRIVATE
        )
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context, prefs: SharedPreferences): RoomDatabase {
        return RoomDatabase.getDatabase(context, prefs)
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiServiceFactory.makeApiService(BuildConfig.SERVER)
    }
}