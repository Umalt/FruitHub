package com.umalt.database.mapper

import com.umalt.data.product.model.Product
import com.umalt.database.model.ProductDBModel

/**
 * Created by Umalt on 2/23/21
 */
object ProductDBModelMapper : Mapper<Product, ProductDBModel> {
    override fun mapToDBModel(obj: Product): ProductDBModel {
        return ProductDBModel(
            obj.id,
            obj.title,
            obj.description,
            obj.composition,
            obj.picUrl,
            obj.price,
            obj.sortIndex
        )
    }

    override fun mapFromDBModel(obj: ProductDBModel): Product {
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