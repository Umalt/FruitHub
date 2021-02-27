package com.umalt.domain.product.port

import com.umalt.domain.product.entity.ProductEntity

/**
 * Created by Umalt on 2/23/21
 */
interface ProductRepository {
    suspend fun saveProducts(products: List<ProductEntity>)

    suspend fun getRemoteProducts(): List<ProductEntity>

    suspend fun getLocalProducts(): List<ProductEntity>

    suspend fun getLocalProductById(id: String): ProductEntity

    suspend fun deleteAll()
}