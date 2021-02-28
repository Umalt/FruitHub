package com.umalt.network.model.response

/**
 * Created by Umalt on 2/22/21
 */
class CategoryResponse(
    val count: Int,
    val items: List<CategoryItem>
)

class CategoryItem(
    val id: String,
    val title: String,
    val sortIndex: Int,
    val products: List<CategoryItemProduct>?
)

class CategoryItemProduct(
    val id: String,
    val sortIndex: Int
)