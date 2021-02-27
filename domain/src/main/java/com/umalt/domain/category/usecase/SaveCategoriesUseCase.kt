package com.umalt.domain.category.usecase

import com.umalt.domain.category.entity.CategoryEntity
import com.umalt.domain.category.port.CategoryRepository

/**
 * Created by Umalt on 2/27/21
 */
class SaveCategoriesUseCase(private val repository: CategoryRepository) {
    suspend fun execute(categories: List<CategoryEntity>) {
        repository.saveCategories(categories)
    }
}