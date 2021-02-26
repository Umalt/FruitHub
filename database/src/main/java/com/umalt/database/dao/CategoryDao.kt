package com.umalt.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.umalt.database.model.CategoryDBModel
import com.umalt.database.model.relation.CategoryWithProducts

/**
 * Created by Umalt on 2/23/21
 */
@Dao
interface CategoryDao : BaseDao<CategoryDBModel> {

    @Transaction
    @Query("SELECT * FROM categories")
    suspend fun getAll(): List<CategoryWithProducts>

    @Transaction
    @Query("SELECT * FROM categories WHERE id=:id")
    suspend fun getById(id: String): CategoryWithProducts

    @Transaction
    suspend fun insertWithProducts(
        itemDao: ItemDao,
        categories: List<CategoryWithProducts>
    ) {
        categories.map {
            insert(it.category)
            it.products?.let { embeddedProducts ->
                itemDao.insert(*embeddedProducts.toTypedArray())
            }
        }
    }

    @Query("DELETE FROM categories")
    suspend fun deleteAll()
}