package com.umalt.fruithub.presentation.app

import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseActivity
import moxy.ktx.moxyPresenter

/**
 * Created by Umalt on 2/23/21
 */
class AppActivity : BaseActivity(R.layout.activity_app) {

    private val presenter: AppPresenter by moxyPresenter { AppPresenter() }

    override fun setProgressVisibility(isVisible: Boolean) {
        TODO("Not yet implemented")
    }
}