package com.umalt.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Umalt on 2/28/21
 */
@Entity(tableName = "users")
class UserDBModel(
    @PrimaryKey
    val name: String
)