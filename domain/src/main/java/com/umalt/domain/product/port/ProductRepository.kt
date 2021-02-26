package com.umalt.domain.product.port

import com.umalt.domain.product.entity.ProductEntity

/**
 * Created by Umalt on 2/23/21
 */
interface ProductRepository {
    suspend fun getRemoteProducts(): List<ProductEntity>

    suspend fun getLocalProducts(): List<ProductEntity>
}