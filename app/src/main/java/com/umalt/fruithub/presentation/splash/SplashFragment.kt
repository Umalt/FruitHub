package com.umalt.fruithub.presentation.splash

import android.os.Bundle
import android.view.View
import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseFragment
import moxy.ktx.moxyPresenter

/**
 * Created by Umalt on 2/26/21
 */
class SplashFragment : BaseFragment(R.layout.fragment_splash), SplashView {

    private val presenter: SplashPresenter by moxyPresenter { SplashPresenter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun openNextScreen() {
        navController.navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment())
    }
}