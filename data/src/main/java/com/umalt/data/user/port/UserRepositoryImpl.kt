package com.umalt.data.user.port

import com.umalt.data.user.mapper.UserEntityMapper
import com.umalt.domain.user.entity.UserEntity
import com.umalt.domain.user.port.UserRepository

/**
 * Created by Umalt on 2/28/21
 */
class UserRepositoryImpl(
    private val userCache: UserCache,
    private val mapper: UserEntityMapper
) : UserRepository {
    override suspend fun getUser(): UserEntity? {
        return userCache.getUser()?.let { mapper.mapToEntity(it) }
    }

    override suspend fun saveUser(user: UserEntity) {
        userCache.insert(mapper.mapFromEntity(user))
    }
}