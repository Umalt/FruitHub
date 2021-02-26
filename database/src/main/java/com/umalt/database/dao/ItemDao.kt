package com.umalt.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.umalt.database.model.ItemDBModel

/**
 * Created by Umalt on 2/23/21
 */
@Dao
interface ItemDao : BaseDao<ItemDBModel> {
    @Query("DELETE FROM embedded_products")
    suspend fun deleteAll()
}