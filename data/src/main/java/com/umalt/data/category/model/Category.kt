package com.umalt.data.category.model

/**
 * Created by Umalt on 2/22/21
 */
class Category(
    val id: String,
    val title: String,
    val sortIndex: Int,
    val products: List<CategoryProduct>?
)

class CategoryProduct(
    val id: String,
    val sortIndex: Int
)