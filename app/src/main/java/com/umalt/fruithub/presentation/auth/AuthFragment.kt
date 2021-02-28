package com.umalt.fruithub.presentation.auth

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import androidx.core.view.updatePadding
import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseFragment
import com.umalt.fruithub.utils.hideKeyboard
import com.umalt.fruithub.utils.toPx
import dev.chrisbanes.insetter.applyInsetter
import moxy.ktx.moxyPresenter

/**
 * Created by Umalt on 2/28/21
 */
class AuthFragment : BaseFragment(R.layout.fragment_auth), AuthView, View.OnClickListener {

    private val presenter: AuthPresenter by moxyPresenter { AuthPresenter() }

    private lateinit var etName: EditText
    private lateinit var btnStartOrdering: Button
    private lateinit var svAuth: ScrollView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.et_auth_user_name)

        svAuth = view.findViewById(R.id.sv_auth)

        btnStartOrdering = view.findViewById(R.id.btn_auth_start_ordering)
        btnStartOrdering.setOnClickListener(this)
        btnStartOrdering.viewTreeObserver.addOnGlobalLayoutListener(
            object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if (btnStartOrdering.height > 0) {
                        val scrollViewPadding = view.height - btnStartOrdering.y + 24.toPx()
                        svAuth.updatePadding(bottom = scrollViewPadding.toInt())
                        svAuth.fullScroll(ScrollView.FOCUS_DOWN)
                        btnStartOrdering.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                }
            }
        )
    }

    override fun View.applySystemWindowsSizes() {
        applyInsetter {
            type(navigationBars = true) {
                padding()
            }
        }
    }

    override fun openNextScreen() {
        etName.hideKeyboard()
        navController.navigate(AuthFragmentDirections.actionAuthFragmentToMenuFragment())
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_auth_start_ordering -> {
                presenter.saveUser(etName.text.toString())
            }
        }
    }
}