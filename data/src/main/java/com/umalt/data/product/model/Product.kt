package com.umalt.data.product.model

/**
 * Created by Umalt on 2/23/21
 */
class Product(
    val id: String,
    val title: String,
    val description: String,
    val composition: String,
    val picUrl: String,
    val price: Double,
    val sortIndex: Int
)