package com.umalt.fruithub.presentation.auth

import com.umalt.domain.user.entity.UserEntity
import com.umalt.domain.user.usecase.SaveUserUseCase
import com.umalt.fruithub.R
import com.umalt.fruithub.di.DIManager
import com.umalt.fruithub.presentation.base.BasePresenter
import com.umalt.fruithub.utils.Utils
import com.umalt.fruithub.utils.handle
import kotlinx.coroutines.launch
import moxy.presenterScope
import javax.inject.Inject

/**
 * Created by Umalt on 2/28/21
 */
class AuthPresenter : BasePresenter<AuthView>() {

    @Inject
    lateinit var saveUserUseCase: SaveUserUseCase

    init {
        DIManager.getAuthSubcomponent().inject(this)
    }

    fun saveUser(name: String?) {
        presenterScope.launch {
            try {
                if (!name.isNullOrBlank()) {
                    saveUserUseCase.execute(UserEntity(name))
                    viewState.openNextScreen()
                } else {
                    viewState.showMessage(
                        Utils.getString(R.string.common_attention),
                        Utils.getString(R.string.fragment_auth_please_enter_name)
                    )
                }
            } catch (e: Exception) {
                e.handle().apply {
                    viewState.showMessage(third, second)
                }
            }
        }
    }
}