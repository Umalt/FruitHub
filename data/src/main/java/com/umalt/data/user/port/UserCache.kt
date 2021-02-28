package com.umalt.data.user.port

import com.umalt.data.base.port.Cache
import com.umalt.data.user.model.User

/**
 * Created by Umalt on 2/28/21
 */
interface UserCache : Cache<User> {
    suspend fun getUser(): User?

    suspend fun saveUser(user: User)
}