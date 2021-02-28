package com.umalt.fruithub.di.module

import com.umalt.data.user.mapper.UserEntityMapper
import com.umalt.data.user.port.UserRepositoryImpl
import com.umalt.database.db.RoomDatabase
import com.umalt.database.mapper.UserDBModeMapper
import com.umalt.database.port.UserCacheImpl
import com.umalt.domain.user.usecase.SaveUserUseCase
import com.umalt.fruithub.di.scope.AuthScope
import dagger.Module
import dagger.Provides

/**
 * Created by Umalt on 2/27/21
 */
@Module
object AuthModule {

    @AuthScope
    @Provides
    fun provideUserRepository(database: RoomDatabase): UserRepositoryImpl {
        return UserRepositoryImpl(
            UserCacheImpl(database, UserDBModeMapper),
            UserEntityMapper
        )
    }

    @AuthScope
    @Provides
    fun provideSaveUserUseCase(repository: UserRepositoryImpl): SaveUserUseCase {
        return SaveUserUseCase(repository)
    }
}