package com.umalt.network.port

import com.umalt.data.category.model.Category
import com.umalt.data.category.port.CategoryApi
import com.umalt.network.ApiService
import com.umalt.network.mapper.CategoryResponseMapper
import javax.inject.Inject

/**
 * Created by Umalt on 2/22/21
 */
class CategoryApiImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: CategoryResponseMapper
) : CategoryApi {
    override suspend fun getCategories(): List<Category> {
        return apiService.getCategories().result.items.map { mapper.mapFromResponse(it) }
    }
}