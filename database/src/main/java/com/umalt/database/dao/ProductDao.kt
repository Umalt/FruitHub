package com.umalt.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.umalt.database.model.ProductDBModel

/**
 * Created by Umalt on 2/23/21
 */
@Dao
interface ProductDao : BaseDao<ProductDBModel> {
    @Transaction
    @Query("SELECT * FROM products")
    suspend fun getAll(): List<ProductDBModel>

    @Transaction
    @Query("SELECT * FROM products WHERE id=:id")
    suspend fun getById(id: String): ProductDBModel

    @Query("DELETE FROM products")
    suspend fun deleteAll()
}