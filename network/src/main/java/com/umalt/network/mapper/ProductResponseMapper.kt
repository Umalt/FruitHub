package com.umalt.network.mapper

import com.umalt.data.product.model.Product
import com.umalt.network.model.response.ProductItem

/**
 * Created by Umalt on 2/22/21
 */
object ProductResponseMapper : Mapper<ProductItem, Product> {
    override fun mapFromResponse(obj: ProductItem): Product {
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