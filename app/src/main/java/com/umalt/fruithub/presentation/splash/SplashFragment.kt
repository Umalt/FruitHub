package com.umalt.fruithub.presentation.splash

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseFragment
import com.umalt.fruithub.presentation.main.MainFragment
import com.umalt.fruithub.presentation.welcome.WelcomeFragment
import moxy.ktx.moxyPresenter

/**
 * Created by Umalt on 2/26/21
 */
class SplashFragment : BaseFragment(R.layout.fragment_splash), SplashView {

    private val presenter: SplashPresenter by moxyPresenter { SplashPresenter() }

    private val logoScaleAnimation: Animation by lazy {
        ScaleAnimation(
            1f, 1.2f,
            1f, 1.2f,
            Animation.RELATIVE_TO_SELF, .5f,
            Animation.RELATIVE_TO_SELF, .5f
        ).apply {
            fillAfter = true
            duration = 700
            repeatMode = Animation.REVERSE
            repeatCount = Animation.INFINITE
        }
    }

    private lateinit var ivLogo: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivLogo = view.findViewById(R.id.iv_splash_logo)
    }

    override fun openNextScreen(isUserExist: Boolean) {
        if (isUserExist) {
            onNavigateListener?.onNavigate(MainFragment(), MainFragment.TAG)
        } else {
            onNavigateListener?.onNavigate(WelcomeFragment(), WelcomeFragment.TAG)
        }
    }

    override fun setProgressVisibility(isVisible: Boolean) {
        if (isVisible) {
            ivLogo.startAnimation(logoScaleAnimation)
        } else {
            logoScaleAnimation.cancel()
        }
    }

    companion object {
        const val TAG = "SplashFragment"
    }
}