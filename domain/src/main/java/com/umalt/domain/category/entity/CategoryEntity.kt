package com.umalt.domain.category.entity

class CategoryEntity constructor(
    val id: String,
    val title: String,
    val sortIndex: Int,
    val products: List<CategoryEntityProduct>?
)

class CategoryEntityProduct(
    val id: String,
    val sortIndex: Int
)