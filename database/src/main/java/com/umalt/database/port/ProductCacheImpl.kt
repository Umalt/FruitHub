package com.umalt.database.port

import com.umalt.data.product.model.Product
import com.umalt.data.product.port.ProductCache
import com.umalt.database.db.RoomDatabase
import com.umalt.database.mapper.ProductDBModelMapper
import javax.inject.Inject

/**
 * Created by Umalt on 2/23/21
 */
class ProductCacheImpl @Inject constructor(
    private val database: RoomDatabase,
    private val mapper: ProductDBModelMapper
) : ProductCache {
    override suspend fun getProducts(): List<Product> {
        return database.productDao().getAll().map { mapper.mapFromDBModel(it) }
    }

    override suspend fun insert(vararg obj: Product) {
        database.productDao().insert(*obj.map { mapper.mapToDBModel(it) }.toTypedArray())
    }

    override suspend fun update(vararg obj: Product) {
        database.productDao().update(*obj.map { mapper.mapToDBModel(it) }.toTypedArray())
    }

    override suspend fun delete(vararg obj: Product) {
        database.productDao().delete(*obj.map { mapper.mapToDBModel(it) }.toTypedArray())
    }

    suspend fun deleteAll() {
        database.productDao().deleteAll()
    }
}