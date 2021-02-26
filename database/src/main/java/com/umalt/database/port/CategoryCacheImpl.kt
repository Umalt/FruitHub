package com.umalt.database.port

import com.umalt.data.category.model.Category
import com.umalt.data.category.model.CategoryProduct
import com.umalt.data.category.port.CategoryCache
import com.umalt.database.db.RoomDatabase
import com.umalt.database.mapper.CategoryDBModelMapper
import javax.inject.Inject

/**
 * Created by Umalt on 2/23/21
 */
class CategoryCacheImpl @Inject constructor(
    private val database: RoomDatabase,
    private val mapper: CategoryDBModelMapper
) : CategoryCache {
    override suspend fun getCategories(): List<Category> {
        return database.categoryDao().getAll().map {
            Category(
                it.category.id,
                it.category.title,
                it.category.sortIndex,
                it.products?.map { product -> CategoryProduct(product.id, product.sortIndex) }
            )
        }
    }

    override suspend fun insert(vararg obj: Category) {
        database.categoryDao().insertWithProducts(
            database.itemDao(),
            obj.map { mapper.mapToDBModel(it) }
        )
    }

    override suspend fun update(vararg obj: Category) {
        database.categoryDao().update(*obj.map { mapper.mapToDBModel(it).category }.toTypedArray())
    }

    override suspend fun delete(vararg obj: Category) {
        database.categoryDao().delete(*obj.map { mapper.mapToDBModel(it).category }.toTypedArray())
    }


    suspend fun deleteAll() {
        database.categoryDao().deleteAll()
    }
}