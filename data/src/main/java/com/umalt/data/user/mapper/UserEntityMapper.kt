package com.umalt.data.user.mapper

import com.umalt.data.base.mapper.Mapper
import com.umalt.data.user.model.User
import com.umalt.domain.user.entity.UserEntity

/**
 * Created by Umalt on 2/28/21
 */
object UserEntityMapper : Mapper<User, UserEntity> {
    override fun mapToEntity(obj: User): UserEntity {
        return UserEntity(obj.name)
    }

    override fun mapFromEntity(obj: UserEntity): User {
        return User(obj.name)
    }
}