package com.umalt.data.category.port

import com.umalt.data.category.mapper.CategoryEntityMapper
import com.umalt.domain.category.entity.CategoryEntity
import com.umalt.domain.category.port.CategoryRepository

/**
 * Created by Umalt on 2/22/21
 */
class CategoryRepositoryImpl(
    private val categoryApi: CategoryApi,
    private val categoryCache: CategoryCache,
    private val mapper: CategoryEntityMapper
) : CategoryRepository {
    override suspend fun saveCategories(categories: List<CategoryEntity>) {
        categoryCache.insert(*categories.map { mapper.mapFromEntity(it) }.toTypedArray())
    }

    override suspend fun getRemoteCategories(): List<CategoryEntity> {
        return categoryApi.getCategories().map { mapper.mapToEntity(it) }
    }

    override suspend fun getLocalCategories(): List<CategoryEntity> {
        return categoryCache.getCategories().map { mapper.mapToEntity(it) }
    }

    override suspend fun getLocalCategoryById(id: String): CategoryEntity {
        return mapper.mapToEntity(categoryCache.getCategoryById(id))
    }

    override suspend fun deleteAll() {
        categoryCache.deleteAll()
    }
}