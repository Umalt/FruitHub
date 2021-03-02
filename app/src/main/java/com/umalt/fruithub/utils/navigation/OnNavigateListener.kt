package com.umalt.fruithub.utils.navigation

import androidx.fragment.app.Fragment

/**
 * Created by Umalt on 3/1/21
 */
interface OnNavigateListener {
    fun onNavigate(fragmentInstance: Fragment, tag: String?, isAddToBackStack: Boolean = false)
}