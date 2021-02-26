package com.umalt.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

/**
 * Created by Umalt on 2/23/21
 */
@Entity(
    tableName = "embedded_products",
    primaryKeys = ["id", "parent_id"],
    indices = [Index("id"), Index("parent_id")],
    foreignKeys = [
        ForeignKey(
            entity = CategoryDBModel::class,
            parentColumns = ["id"],
            childColumns = ["parent_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class ItemDBModel(
    val id: String,
    @ColumnInfo(name = "parent_id") val parentId: String,
    val sortIndex: Int
)