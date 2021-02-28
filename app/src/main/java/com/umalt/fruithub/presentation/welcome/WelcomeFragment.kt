package com.umalt.fruithub.presentation.welcome

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ScrollView
import androidx.core.view.updatePadding
import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseFragment
import com.umalt.fruithub.utils.toPx
import dev.chrisbanes.insetter.applyInsetter
import moxy.ktx.moxyPresenter

/**
 * Created by Umalt on 2/27/21
 */
class WelcomeFragment : BaseFragment(R.layout.fragment_welcome), WelcomeView, View.OnClickListener {

    private val presenter: WelcomePresenter by moxyPresenter { WelcomePresenter() }

    private lateinit var btnContinue: Button
    private lateinit var svWelcome: ScrollView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        svWelcome = view.findViewById(R.id.sv_welcome)

        btnContinue = view.findViewById(R.id.btn_welcome_continue)
        btnContinue.setOnClickListener(this)
        btnContinue.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (btnContinue.height > 0) {
                    val scrollViewPadding = view.height - btnContinue.y + 24.toPx()
                    svWelcome.updatePadding(bottom = scrollViewPadding.toInt())
                    btnContinue.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            }
        })
    }

    override fun View.applySystemWindowsSizes() {
        applyInsetter {
            type(navigationBars = true) {
                padding()
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_welcome_continue -> {

            }
        }
    }
}
