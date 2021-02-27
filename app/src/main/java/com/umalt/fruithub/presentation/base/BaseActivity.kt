package com.umalt.fruithub.presentation.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import com.umalt.fruithub.R
import moxy.MvpAppCompatActivity

/**
 * Created by Umalt on 2/26/21
 */
abstract class BaseActivity(@LayoutRes contentLayoutId: Int) :
    MvpAppCompatActivity(contentLayoutId), BaseView {

    override fun showMessage(
        title: String?,
        message: String?,
        posBtnTxt: String?,
        negBtnTxt: String?,
        posBtnAction: (() -> Unit)?,
        negBtnAction: (() -> Unit)?,
        cancellable: Boolean
    ) {
        AlertDialog.Builder(this).apply {
            setTitle(title)
            setMessage(message)
            setCancelable(cancellable)
            setPositiveButton(posBtnTxt ?: getString(R.string.common_ok)) { _, _ ->
                if (posBtnAction != null) posBtnAction()
            }
            if (!negBtnTxt.isNullOrBlank()) {
                setPositiveButton(negBtnTxt) { _, _ -> if (negBtnAction != null) negBtnAction() }
            }
        }.show()
    }
}