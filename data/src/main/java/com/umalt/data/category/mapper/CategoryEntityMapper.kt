package com.umalt.data.category.mapper

import com.umalt.data.base.mapper.Mapper
import com.umalt.data.category.model.Category
import com.umalt.data.category.model.CategoryProduct
import com.umalt.domain.category.entity.CategoryEntity
import com.umalt.domain.category.entity.CategoryEntityProduct

/**
 * Created by Umalt on 2/22/21
 */
class CategoryEntityMapper : Mapper<Category, CategoryEntity> {
    override fun mapToEntity(obj: Category): CategoryEntity {
        return CategoryEntity(
            obj.id,
            obj.title,
            obj.sortIndex,
            obj.products?.map { CategoryEntityProduct(obj.id, obj.sortIndex) }
        )
    }

    override fun mapFromEntity(obj: CategoryEntity): Category {
        return Category(
            obj.id,
            obj.title,
            obj.sortIndex,
            obj.products?.map { CategoryProduct(it.id, it.sortIndex) }
        )
    }
}