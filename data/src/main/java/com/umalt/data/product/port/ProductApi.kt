package com.umalt.data.product.port

import com.umalt.data.product.model.Product

/**
 * Created by Umalt on 2/23/21
 */
interface ProductApi {
    suspend fun getProducts(): List<Product>
}