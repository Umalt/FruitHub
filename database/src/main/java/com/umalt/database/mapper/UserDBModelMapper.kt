package com.umalt.database.mapper

import com.umalt.data.user.model.User
import com.umalt.database.model.UserDBModel

/**
 * Created by Umalt on 2/28/21
 */
object UserDBModeMapper : Mapper<User, UserDBModel> {
    override fun mapToDBModel(obj: User): UserDBModel {
        return UserDBModel(obj.name)
    }

    override fun mapFromDBModel(obj: UserDBModel): User {
        return User(obj.name)
    }
}