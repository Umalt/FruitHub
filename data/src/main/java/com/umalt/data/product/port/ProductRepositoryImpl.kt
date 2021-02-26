package com.umalt.data.product.port

import com.umalt.data.product.mapper.ProductEntityMapper
import com.umalt.domain.product.entity.ProductEntity
import com.umalt.domain.product.port.ProductRepository

/**
 * Created by Umalt on 2/23/21
 */
class ProductRepositoryImpl(
    private val api: ProductApi,
    private val database: ProductCache,
    private val mapper: ProductEntityMapper
) : ProductRepository {
    override suspend fun getRemoteProducts(): List<ProductEntity> {
        return api.getProducts().map { mapper.mapToEntity(it) }
    }

    override suspend fun getLocalProducts(): List<ProductEntity> {
        return database.getProducts().map { mapper.mapToEntity(it) }
    }
}