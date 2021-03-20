package com.umalt.fruithub.presentation.catalog

import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseFragment
import moxy.ktx.moxyPresenter

/**
 * Created by Umalt on 3/20/21
 */
class CatalogFragment : BaseFragment(R.layout.fragment_catalog), CatalogView {

    private val presenter: CatalogPresenter by moxyPresenter { CatalogPresenter() }

    companion object {
        const val TAG = "CatalogFragment"
    }
}