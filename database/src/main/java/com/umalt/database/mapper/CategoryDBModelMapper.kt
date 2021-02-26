package com.umalt.database.mapper

import com.umalt.data.category.model.Category
import com.umalt.data.category.model.CategoryProduct
import com.umalt.database.model.CategoryDBModel
import com.umalt.database.model.ItemDBModel
import com.umalt.database.model.relation.CategoryWithProducts

/**
 * Created by Umalt on 2/23/21
 */
class CategoryDBModelMapper : Mapper<Category, CategoryWithProducts> {
    override fun mapToDBModel(obj: Category): CategoryWithProducts {
        return CategoryWithProducts(
            CategoryDBModel(obj.id, obj.title, obj.sortIndex),
            obj.products?.map { ItemDBModel(it.id, obj.id, it.sortIndex) }
        )
    }

    override fun mapFromDBModel(obj: CategoryWithProducts): Category {
        return Category(
            obj.category.id,
            obj.category.title,
            obj.category.sortIndex,
            obj.products?.map { CategoryProduct(it.id, it.sortIndex) }
        )
    }
}