package com.umalt.fruithub.di.component

import com.umalt.fruithub.di.module.CatalogModule
import com.umalt.fruithub.di.scope.CatalogScope
import com.umalt.fruithub.presentation.catalog.CatalogPresenter
import dagger.Subcomponent

/**
 * Created by Umalt on 2/27/21
 */
@CatalogScope
@Subcomponent(modules = [CatalogModule::class])
interface CatalogSubcomponent {
    fun inject(presenter: CatalogPresenter)
}