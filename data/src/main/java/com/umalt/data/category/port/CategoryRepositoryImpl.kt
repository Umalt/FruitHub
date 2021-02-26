package com.umalt.data.category.port

import com.umalt.data.category.mapper.CategoryEntityMapper
import com.umalt.domain.category.entity.CategoryEntity
import com.umalt.domain.category.port.CategoryRepository

/**
 * Created by Umalt on 2/22/21
 */
class CategoryRepositoryImpl(
    private val api: CategoryApi,
    private val database: CategoryCache,
    private val mapper: CategoryEntityMapper
) : CategoryRepository {
    override suspend fun getRemoteCategories(): List<CategoryEntity> {
        return api.getCategories().map { mapper.mapToEntity(it) }
    }

    override suspend fun getLocalCategories(): List<CategoryEntity> {
        return database.getCategories().map { mapper.mapToEntity(it) }
    }
}