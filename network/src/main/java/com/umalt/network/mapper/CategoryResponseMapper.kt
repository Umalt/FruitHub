package com.umalt.network.mapper

import com.umalt.data.category.model.Category
import com.umalt.data.category.model.CategoryProduct
import com.umalt.network.model.response.CategoryResponse

/**
 * Created by Umalt on 2/22/21
 */
class CategoryResponseMapper : Mapper<CategoryResponse, Category> {
    override fun mapFromResponse(obj: CategoryResponse): Category {
        return Category(
            obj.id,
            obj.title,
            obj.sortIndex,
            obj.products?.map { CategoryProduct(it.id, it.sortIndex) }
        )
    }
}