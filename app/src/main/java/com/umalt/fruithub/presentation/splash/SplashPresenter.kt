package com.umalt.fruithub.presentation.splash

import com.umalt.domain.category.usecase.DeleteAllCategoriesUseCase
import com.umalt.domain.category.usecase.GetLocalCategoriesUseCase
import com.umalt.domain.category.usecase.GetRemoteCategoriesUseCase
import com.umalt.domain.category.usecase.SaveCategoriesUseCase
import com.umalt.domain.product.usecase.DeleteAllProductsUseCase
import com.umalt.domain.product.usecase.GetLocalProductsUseCase
import com.umalt.domain.product.usecase.GetRemoteProductsUseCase
import com.umalt.domain.product.usecase.SaveProductsUseCase
import com.umalt.fruithub.di.DIManager
import com.umalt.fruithub.presentation.base.BasePresenter
import com.umalt.fruithub.utils.Utils.isNetworkError
import com.umalt.fruithub.utils.handle
import kotlinx.coroutines.launch
import moxy.presenterScope
import javax.inject.Inject

/**
 * Created by Umalt on 2/27/21
 */
class SplashPresenter : BasePresenter<SplashView>() {

    @Inject
    lateinit var getRemoteCategoriesUseCase: GetRemoteCategoriesUseCase

    @Inject
    lateinit var getLocalCategoriesUseCase: GetLocalCategoriesUseCase

    @Inject
    lateinit var saveCategoriesUseCase: SaveCategoriesUseCase

    @Inject
    lateinit var deleteAllCategoriesUseCase: DeleteAllCategoriesUseCase

    @Inject
    lateinit var getRemoteProductsUseCase: GetRemoteProductsUseCase

    @Inject
    lateinit var getLocalProductsUseCase: GetLocalProductsUseCase

    @Inject
    lateinit var saveProductsUseCase: SaveProductsUseCase

    @Inject
    lateinit var deleteAllProductsUseCase: DeleteAllProductsUseCase

    init {
        DIManager.getSplashSubcomponent().inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        presenterScope.launch {
            try {
                val remoteCategories = getRemoteCategoriesUseCase.execute()
                deleteAllCategoriesUseCase.execute()
                saveCategoriesUseCase.execute(remoteCategories)

                val remoteProducts = getRemoteProductsUseCase.execute()
                deleteAllProductsUseCase.execute()
                saveProductsUseCase.execute(remoteProducts)

                viewState.openNextScreen()
            } catch (e: Exception) {
                e.handle().apply { viewState.showMessage(third, second) }
                if (e.isNetworkError() &&
                    getLocalCategoriesUseCase.execute().isNotEmpty() &&
                    getLocalProductsUseCase.execute().isNotEmpty()
                ) {
                    viewState.openNextScreen()
                }
            }
        }
    }
}