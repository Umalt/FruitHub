package com.umalt.domain.user.port

import com.umalt.domain.user.entity.UserEntity

/**
 * Created by Umalt on 2/28/21
 */
interface UserRepository {
    suspend fun getUser(): UserEntity?

    suspend fun saveUser(user: UserEntity)
}