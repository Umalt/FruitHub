package com.umalt.data.product.port

import com.umalt.data.base.port.Cache
import com.umalt.data.product.model.Product

/**
 * Created by Umalt on 2/23/21
 */
interface ProductCache : Cache<Product> {
    suspend fun getProducts(): List<Product>
}