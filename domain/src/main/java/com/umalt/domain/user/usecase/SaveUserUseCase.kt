package com.umalt.domain.user.usecase

import com.umalt.domain.user.entity.UserEntity
import com.umalt.domain.user.port.UserRepository

/**
 * Created by Umalt on 2/28/21
 */
class SaveUserUseCase(private val repository: UserRepository) {
    suspend fun execute(user: UserEntity) {
        return repository.saveUser(user)
    }
}