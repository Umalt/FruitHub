package com.umalt.data.category.port

import com.umalt.data.base.port.Cache
import com.umalt.data.category.model.Category

/**
 * Created by Umalt on 2/22/21
 */
interface CategoryCache : Cache<Category> {
    suspend fun getCategoryById(id: String): Category

    suspend fun getCategories(): List<Category>

    suspend fun deleteAll()
}