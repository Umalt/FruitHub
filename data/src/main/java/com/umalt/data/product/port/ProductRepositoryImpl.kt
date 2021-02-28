package com.umalt.data.product.port

import com.umalt.data.product.mapper.ProductEntityMapper
import com.umalt.domain.product.entity.ProductEntity
import com.umalt.domain.product.port.ProductRepository

/**
 * Created by Umalt on 2/23/21
 */
class ProductRepositoryImpl(
    private val productApi: ProductApi,
    private val productCache: ProductCache,
    private val mapper: ProductEntityMapper
) : ProductRepository {
    override suspend fun saveProducts(products: List<ProductEntity>) {
        productCache.insert(*products.map { mapper.mapFromEntity(it) }.toTypedArray())
    }

    override suspend fun getRemoteProducts(): List<ProductEntity> {
        return productApi.getProducts().map { mapper.mapToEntity(it) }
    }

    override suspend fun getLocalProducts(): List<ProductEntity> {
        return productCache.getProducts().map { mapper.mapToEntity(it) }
    }

    override suspend fun getLocalProductById(id: String): ProductEntity {
        return mapper.mapToEntity(productCache.getProductById(id))
    }

    override suspend fun deleteAll() {
        productCache.deleteAll()
    }
}