package com.umalt.fruithub.presentation.main

import com.umalt.fruithub.presentation.base.BasePresenter
import java.util.*

/**
 * Created by Umalt on 3/1/21
 */
class MainPresenter : BasePresenter<MainView>() {

    private val fragmentStack = Stack<String>()

    fun addFragmentToStack(tag: String) {
        if (fragmentStack.contains(tag)) {
            fragmentStack.remove(tag)
        }
        fragmentStack.add(tag)
    }

    fun popFragmentStack() {
        if (fragmentStack.size > 1) {
            fragmentStack.pop()
            viewState.openScreen(fragmentStack.lastElement() as String)
        } else {
            viewState.minimizeApp()
        }
    }
}