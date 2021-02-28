package com.umalt.domain.category.port

import com.umalt.domain.category.entity.CategoryEntity

/**
 * Created by Umalt on 2/22/21
 */
interface CategoryRepository {
    suspend fun saveCategories(categories: List<CategoryEntity>)

    suspend fun getRemoteCategories(): List<CategoryEntity>

    suspend fun getLocalCategories(): List<CategoryEntity>

    suspend fun getLocalCategoryById(id: String): CategoryEntity

    suspend fun deleteAll()
}