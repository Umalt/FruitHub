package com.umalt.fruithub.di.module

import com.umalt.data.user.mapper.UserEntityMapper
import com.umalt.data.user.port.UserRepositoryImpl
import com.umalt.database.db.RoomDatabase
import com.umalt.database.mapper.UserDBModeMapper
import com.umalt.database.port.UserCacheImpl
import com.umalt.domain.user.usecase.GetUserUseCase
import com.umalt.fruithub.di.scope.CatalogScope
import dagger.Module
import dagger.Provides

/**
 * Created by Umalt on 2/27/21
 */
@Module
object CatalogModule {

    @CatalogScope
    @Provides
    fun provideUserRepository(database: RoomDatabase): UserRepositoryImpl {
        return UserRepositoryImpl(
            UserCacheImpl(database, UserDBModeMapper),
            UserEntityMapper
        )
    }

    @CatalogScope
    @Provides
    fun provideGetUserUseCase(repository: UserRepositoryImpl): GetUserUseCase {
        return GetUserUseCase(repository)
    }
}