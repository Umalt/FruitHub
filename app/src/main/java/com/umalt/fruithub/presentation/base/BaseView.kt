package com.umalt.fruithub.presentation.base

import moxy.MvpView

/**
 * Created by Umalt on 2/26/21
 */
interface BaseView : MvpView {
    fun showMessage(
        title: String?,
        message: String?,
        posBtnTxt: String? = null,
        negBtnTxt: String? = null,
        posBtnAction: (() -> Unit)? = null,
        negBtnAction: (() -> Unit)? = null,
        cancellable: Boolean = true
    )

    fun setProgressVisibility(isVisible: Boolean)
}