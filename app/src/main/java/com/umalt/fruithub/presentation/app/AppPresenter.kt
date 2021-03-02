package com.umalt.fruithub.presentation.app

import com.umalt.fruithub.di.DIManager
import com.umalt.fruithub.presentation.base.BasePresenter

/**
 * Created by Umalt on 2/27/21
 */
class AppPresenter : BasePresenter<AppView>() {

    init {
        DIManager.getAppSubcomponent().inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.launchSplash()
    }
}