package com.umalt.fruithub.presentation.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import moxy.MvpAppCompatFragment

/**
 * Created by Umalt on 2/26/21
 */
abstract class BaseFragment(@LayoutRes contentLayoutId: Int) :
    MvpAppCompatFragment(contentLayoutId) {

    protected val navController: NavController by lazy { findNavController() }

    private var baseActivity: BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = context as? BaseActivity
    }

    fun showMessage(
        title: String?,
        message: String?,
        posBtnTxt: String?,
        negBtnTxt: String?,
        posBtnAction: (() -> Unit)?,
        negBtnAction: (() -> Unit)?,
        cancellable: Boolean
    ) {
        baseActivity?.showMessage(
            title, message, posBtnTxt, negBtnTxt, posBtnAction, negBtnAction, cancellable
        )
    }

    open fun setProgressVisibility(isVisible: Boolean) {
        baseActivity?.setProgressVisibility(isVisible)
    }
}