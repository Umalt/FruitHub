package com.umalt.data.product.mapper

import com.umalt.data.base.mapper.Mapper
import com.umalt.data.product.model.Product
import com.umalt.domain.product.entity.ProductEntity

/**
 * Created by Umalt on 2/23/21
 */
class ProductEntityMapper : Mapper<Product, ProductEntity> {
    override fun mapToEntity(obj: Product): ProductEntity {
        return ProductEntity(
            obj.id,
            obj.title,
            obj.description,
            obj.composition,
            obj.picUrl,
            obj.price,
            obj.sortIndex
        )
    }

    override fun mapFromEntity(obj: ProductEntity): Product {
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