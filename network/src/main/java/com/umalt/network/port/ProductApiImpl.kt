package com.umalt.network.port

import com.umalt.data.product.model.Product
import com.umalt.data.product.port.ProductApi
import com.umalt.network.ApiService
import com.umalt.network.mapper.ProductResponseMapper
import javax.inject.Inject

/**
 * Created by Umalt on 2/22/21
 */
class ProductApiImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ProductResponseMapper
) : ProductApi {
    override suspend fun getProducts(): List<Product> {
        return apiService.getProducts().result.items.map { mapper.mapFromResponse(it) }
    }
}