package com.umalt.domain.product.entity

/**
 * Created by Umalt on 2/23/21
 */
class ProductEntity(
    val id: String,
    val title: String,
    val description: String,
    val composition: String,
    val picUrl: String,
    val price: Double,
    val sortIndex: Int
)