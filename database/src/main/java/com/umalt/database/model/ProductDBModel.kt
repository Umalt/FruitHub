package com.umalt.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Umalt on 2/22/21
 */
@Entity(tableName = "products")
class ProductDBModel(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val composition: String,
    val picUrl: String,
    val price: Double,
    val sortIndex: Int
)