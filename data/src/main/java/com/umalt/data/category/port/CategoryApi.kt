package com.umalt.data.category.port

import com.umalt.data.category.model.Category

/**
 * Created by Umalt on 2/22/21
 */
interface CategoryApi {
    suspend fun getCategories(): List<Category>
}