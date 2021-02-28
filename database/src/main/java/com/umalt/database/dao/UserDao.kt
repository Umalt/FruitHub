package com.umalt.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.umalt.database.model.UserDBModel

/**
 * Created by Umalt on 2/28/21
 */
@Dao
interface UserDao : BaseDao<UserDBModel> {
    @Transaction
    @Query("SELECT * FROM users")
    suspend fun getAll(): List<UserDBModel>
}