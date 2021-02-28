package com.umalt.database.db

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Database
import androidx.room.Room
import com.umalt.database.dao.CategoryDao
import com.umalt.database.dao.ItemDao
import com.umalt.database.dao.ProductDao
import com.umalt.database.model.CategoryDBModel
import com.umalt.database.model.ItemDBModel
import com.umalt.database.model.ProductDBModel

/**
 * Created by Umalt on 2/23/21
 */
@Database(
    entities = [
        CategoryDBModel::class,
        ProductDBModel::class,
        ItemDBModel::class
    ],
    version = 1
)
abstract class RoomDatabase : androidx.room.RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun itemDao(): ItemDao
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null

        private const val DB_NAME = "fruit_hub_db"

        private lateinit var prefs: SharedPreferences

        fun getDatabase(context: Context, prefs: SharedPreferences): RoomDatabase {
            Companion.prefs = prefs
            val tempInstance = INSTANCE
            tempInstance?.let { return it }
            synchronized(this) {
                val instance = Room.databaseBuilder(context, RoomDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}