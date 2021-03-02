package com.umalt.fruithub.presentation.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseFragment
import moxy.ktx.moxyPresenter

/**
 * Created by Umalt on 3/1/21
 */
class MainFragment : BaseFragment(R.layout.fragment_main), MainView {

    private val presenter: MainPresenter by moxyPresenter { MainPresenter() }

    private lateinit var flContainer: FrameLayout
    private lateinit var bnvMenu: BottomNavigationView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onBackPressedAction = {
            presenter.popFragmentStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bnvMenu = view.findViewById(R.id.bnv_main_menu)
        flContainer = view.findViewById(R.id.fl_main_container)
    }

    override fun openScreen(fragmentTag: String) {
        presenter.addFragmentToStack(fragmentTag)
        // attach fragments here
    }

    override fun minimizeApp() {
        activity?.moveTaskToBack(true)
    }

    companion object {
        const val TAG = "MainFragment"
    }
}