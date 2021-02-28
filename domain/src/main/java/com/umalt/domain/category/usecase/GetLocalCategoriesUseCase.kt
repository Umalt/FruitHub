package com.umalt.domain.category.usecase

import com.umalt.domain.category.entity.CategoryEntity
import com.umalt.domain.category.port.CategoryRepository

/**
 * Created by Umalt on 2/27/21
 */
class GetLocalCategoriesUseCase(private val repository: CategoryRepository) {
    suspend fun execute(): List<CategoryEntity> {
        return repository.getLocalCategories()
    }
}