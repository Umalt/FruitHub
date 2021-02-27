package com.umalt.fruithub.presentation.welcome

import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseFragment
import moxy.ktx.moxyPresenter

/**
 * Created by Umalt on 2/27/21
 */
class WelcomeFragment : BaseFragment(R.layout.fragment_welcome), WelcomeView {

    private val presenter: WelcomePresenter by moxyPresenter { WelcomePresenter() }
}
