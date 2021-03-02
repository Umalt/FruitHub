package com.umalt.fruithub.presentation.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseActivity
import com.umalt.fruithub.presentation.base.BaseFragment
import com.umalt.fruithub.presentation.splash.SplashFragment
import com.umalt.fruithub.utils.navigation.OnNavigateListener
import com.umalt.fruithub.utils.navigation.attachFragment
import moxy.ktx.moxyPresenter

/**
 * Created by Umalt on 2/23/21
 */
class AppActivity : BaseActivity(R.layout.activity_app), AppView, OnNavigateListener {

    private val presenter: AppPresenter by moxyPresenter { AppPresenter() }

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_FruitHub) // set default app theme instead fullscreen theme
        super.onCreate(savedInstanceState)
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressedAction?.invoke() ?: super.onBackPressed()
    }

    override fun launchSplash() {
        onNavigate(SplashFragment(), SplashFragment.TAG)
    }

    override fun setProgressVisibility(isVisible: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onNavigate(fragmentInstance: Fragment, tag: String?, isAddToBackStack: Boolean) {
        supportFragmentManager.attachFragment(
            R.id.fl_app_container,
            fragmentInstance,
            tag,
            isAddToBackStack
        )
    }
}