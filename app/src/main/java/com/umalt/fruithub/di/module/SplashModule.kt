package com.umalt.fruithub.di.module

import com.umalt.data.category.mapper.CategoryEntityMapper
import com.umalt.data.category.port.CategoryRepositoryImpl
import com.umalt.data.product.mapper.ProductEntityMapper
import com.umalt.data.product.port.ProductRepositoryImpl
import com.umalt.data.user.mapper.UserEntityMapper
import com.umalt.data.user.port.UserRepositoryImpl
import com.umalt.database.db.RoomDatabase
import com.umalt.database.mapper.CategoryDBModelMapper
import com.umalt.database.mapper.ProductDBModelMapper
import com.umalt.database.mapper.UserDBModeMapper
import com.umalt.database.port.CategoryCacheImpl
import com.umalt.database.port.ProductCacheImpl
import com.umalt.database.port.UserCacheImpl
import com.umalt.domain.category.usecase.DeleteAllCategoriesUseCase
import com.umalt.domain.category.usecase.GetLocalCategoriesUseCase
import com.umalt.domain.category.usecase.GetRemoteCategoriesUseCase
import com.umalt.domain.category.usecase.SaveCategoriesUseCase
import com.umalt.domain.product.usecase.DeleteAllProductsUseCase
import com.umalt.domain.product.usecase.GetLocalProductsUseCase
import com.umalt.domain.product.usecase.GetRemoteProductsUseCase
import com.umalt.domain.product.usecase.SaveProductsUseCase
import com.umalt.domain.user.usecase.GetUserUseCase
import com.umalt.fruithub.di.scope.SplashScope
import com.umalt.network.ApiService
import com.umalt.network.mapper.CategoryResponseMapper
import com.umalt.network.mapper.ProductResponseMapper
import com.umalt.network.port.CategoryApiImpl
import com.umalt.network.port.ProductApiImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Umalt on 2/27/21
 */
@Module
object SplashModule {
    @SplashScope
    @Provides
    fun provideCategoryRepository(
        db: RoomDatabase,
        apiService: ApiService,
    ): CategoryRepositoryImpl {
        return CategoryRepositoryImpl(
            CategoryApiImpl(apiService, CategoryResponseMapper),
            CategoryCacheImpl(db, CategoryDBModelMapper),
            CategoryEntityMapper
        )
    }

    @SplashScope
    @Provides
    fun provideProductRepository(
        db: RoomDatabase,
        apiService: ApiService,
    ): ProductRepositoryImpl {
        return ProductRepositoryImpl(
            ProductApiImpl(apiService, ProductResponseMapper),
            ProductCacheImpl(db, ProductDBModelMapper),
            ProductEntityMapper
        )
    }

    @SplashScope
    @Provides
    fun provideDeleteAllProductsUseCase(repository: ProductRepositoryImpl): DeleteAllProductsUseCase {
        return DeleteAllProductsUseCase(repository)
    }

    @SplashScope
    @Provides
    fun provideSaveProductsUseCase(repository: ProductRepositoryImpl): SaveProductsUseCase {
        return SaveProductsUseCase(repository)
    }

    @SplashScope
    @Provides
    fun provideGetRemoteProductsUseCase(repository: ProductRepositoryImpl): GetRemoteProductsUseCase {
        return GetRemoteProductsUseCase(repository)
    }

    @SplashScope
    @Provides
    fun provideGetLocalProductsUseCase(repository: ProductRepositoryImpl): GetLocalProductsUseCase {
        return GetLocalProductsUseCase(repository)
    }

    @SplashScope
    @Provides
    fun provideDeleteAllCategoriesUseCase(repository: CategoryRepositoryImpl): DeleteAllCategoriesUseCase {
        return DeleteAllCategoriesUseCase(repository)
    }

    @SplashScope
    @Provides
    fun provideSaveCategoriesUseCase(repository: CategoryRepositoryImpl): SaveCategoriesUseCase {
        return SaveCategoriesUseCase(repository)
    }

    @SplashScope
    @Provides
    fun provideGetRemoteCategoriesUseCase(repository: CategoryRepositoryImpl): GetRemoteCategoriesUseCase {
        return GetRemoteCategoriesUseCase(repository)
    }

    @SplashScope
    @Provides
    fun provideGetLocalCategoriesUseCase(repository: CategoryRepositoryImpl): GetLocalCategoriesUseCase {
        return GetLocalCategoriesUseCase(repository)
    }

    @SplashScope
    @Provides
    fun provideUserRepository(database: RoomDatabase): UserRepositoryImpl {
        return UserRepositoryImpl(
            UserCacheImpl(database, UserDBModeMapper),
            UserEntityMapper
        )
    }

    @SplashScope
    @Provides
    fun provideGetUserUseCase(repository: UserRepositoryImpl): GetUserUseCase {
        return GetUserUseCase(repository)
    }
}