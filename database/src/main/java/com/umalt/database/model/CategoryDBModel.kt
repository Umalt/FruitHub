package com.umalt.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Umalt on 2/22/21
 */
@Entity(tableName = "categories")
class CategoryDBModel(
    @PrimaryKey val id: String,
    val title: String,
    val sortIndex: Int
)