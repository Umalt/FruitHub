package com.umalt.network.mapper

import com.umalt.data.product.model.Product
import com.umalt.network.model.response.ProductResponse

/**
 * Created by Umalt on 2/22/21
 */
class ProductResponseMapper : Mapper<ProductResponse, Product> {
    override fun mapFromResponse(obj: ProductResponse): Product {
        return Product(
            obj.id,
            obj.title,
            obj.description,
            obj.composition,
            obj.picUrl,
            obj.price,
            obj.sortIndex
        )
    }
}