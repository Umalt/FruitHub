package com.umalt.fruithub.presentation.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.IdRes
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.umalt.fruithub.R
import com.umalt.fruithub.presentation.base.BaseFragment
import com.umalt.fruithub.presentation.cart.CartFragment
import com.umalt.fruithub.presentation.catalog.CatalogFragment
import com.umalt.fruithub.presentation.order.list.OrdersListFragment
import com.umalt.fruithub.utils.navigation.attachFragment
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

        bnvMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_catalog -> openScreen(CatalogFragment.TAG)
                R.id.action_orders -> openScreen(OrdersListFragment.TAG)
                R.id.action_cart -> openScreen(CartFragment.TAG)
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun openScreen(fragmentTag: String) {
        presenter.addFragmentToStack(fragmentTag)
        val fragment = when (fragmentTag) {
            CatalogFragment.TAG -> {
                selectNavigationItem(R.id.action_catalog)
                CatalogFragment()
            }
            OrdersListFragment.TAG -> {
                selectNavigationItem(R.id.action_orders)
                OrdersListFragment()
            }
            else -> {
                selectNavigationItem(R.id.action_cart)
                CatalogFragment()
            }
        }
        childFragmentManager.attachFragment(R.id.fl_main_container, fragment, fragmentTag)
    }

    override fun minimizeApp() {
        activity?.moveTaskToBack(true)
    }

    private fun selectNavigationItem(@IdRes id: Int) {
        bnvMenu.menu.findItem(id).isChecked = true
    }

    companion object {
        const val TAG = "MainFragment"
    }
}