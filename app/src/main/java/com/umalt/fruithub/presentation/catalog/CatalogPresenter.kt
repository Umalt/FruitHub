package com.umalt.fruithub.presentation.catalog

import com.umalt.domain.user.usecase.GetUserUseCase
import com.umalt.fruithub.di.DIManager
import com.umalt.fruithub.presentation.base.BasePresenter
import kotlinx.coroutines.launch
import moxy.presenterScope
import javax.inject.Inject

/**
 * Created by Umalt on 3/20/21
 */
class CatalogPresenter : BasePresenter<CatalogView>() {

    @Inject
    lateinit var getUserUseCase: GetUserUseCase

    init {
        DIManager.getCatalogSubcomponent().inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launch {
            val user = getUserUseCase.execute()
            user?.name
        }

    }
}