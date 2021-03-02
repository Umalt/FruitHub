package com.umalt.fruithub.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import com.umalt.fruithub.utils.navigation.OnNavigateListener
import dev.chrisbanes.insetter.applyInsetter
import moxy.MvpAppCompatFragment

/**
 * Created by Umalt on 2/26/21
 */
abstract class BaseFragment(@LayoutRes contentLayoutId: Int) :
    MvpAppCompatFragment(contentLayoutId) {

    private var baseActivity: BaseActivity? = null

    protected var onNavigateListener: OnNavigateListener? = null

    var onBackPressedAction: (() -> Unit)? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = context as? BaseActivity
        onNavigateListener = context as? OnNavigateListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.applySystemWindowsInsets()
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

    open fun View.applySystemWindowsInsets() {
        applyInsetter {
            type(statusBars = true) {
                padding()
            }
        }
    }
}