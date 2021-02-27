package com.umalt.network.model.response

/**
 * Created by Umalt on 2/23/21
 */
class ProductResponse(
    val count: Int,
    val items: List<ProductItem>
)

class ProductItem(
    val id: String,
    val title: String,
    val description: String,
    val composition: String,
    val picUrl: String,
    val price: Double,
    val sortIndex: Int
)