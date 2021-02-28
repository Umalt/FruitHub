package com.umalt.fruithub.presentation.base

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import com.umalt.fruithub.R
import moxy.MvpAppCompatActivity

/**
 * Created by Umalt on 2/26/21
 */
abstract class BaseActivity(@LayoutRes contentLayoutId: Int) :
    MvpAppCompatActivity(contentLayoutId), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_FruitHub) // set default app theme instead fullscreen theme
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

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