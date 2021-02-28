package com.umalt.fruithub.presentation.base

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

/**
 * Created by Umalt on 2/26/21
 */
interface BaseView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(
        title: String?,
        message: String?,
        posBtnTxt: String? = null,
        negBtnTxt: String? = null,
        posBtnAction: (() -> Unit)? = null,
        negBtnAction: (() -> Unit)? = null,
        cancellable: Boolean = true
    )

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setProgressVisibility(isVisible: Boolean)
}