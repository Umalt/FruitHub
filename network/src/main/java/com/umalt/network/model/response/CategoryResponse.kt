package com.umalt.network.model.response

/**
 * Created by Umalt on 2/22/21
 */
class CategoryResponse(
    val id: String,
    val title: String,
    val sortIndex: Int,
    val products: List<CategoryResponseProduct>?
)

class CategoryResponseProduct(
    val id: String,
    val sortIndex: Int
)