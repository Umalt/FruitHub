package com.umalt.database.port

import com.umalt.data.user.model.User
import com.umalt.data.user.port.UserCache
import com.umalt.database.db.RoomDatabase
import com.umalt.database.mapper.UserDBModeMapper
import javax.inject.Inject

/**
 * Created by Umalt on 2/28/21
 */
class UserCacheImpl @Inject constructor(
    private val database: RoomDatabase,
    private val mapper: UserDBModeMapper
) : UserCache {
    override suspend fun getUser(): User? {
        val users = database.userDao().getAll()
        if (users.isEmpty()) return null
        return mapper.mapFromDBModel(users[0])
    }

    override suspend fun saveUser(user: User) {
        database.userDao().insert(mapper.mapToDBModel(user))
    }

    override suspend fun insert(vararg obj: User) {
        database.userDao().insert(*obj.map { mapper.mapToDBModel(it) }.toTypedArray())
    }

    override suspend fun update(vararg obj: User) {
        database.userDao().update(*obj.map { mapper.mapToDBModel(it) }.toTypedArray())
    }

    override suspend fun delete(vararg obj: User) {
        database.userDao().delete(*obj.map { mapper.mapToDBModel(it) }.toTypedArray())
    }
}