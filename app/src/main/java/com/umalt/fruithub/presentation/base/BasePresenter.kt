package com.umalt.fruithub.presentation.base

import moxy.MvpPresenter
import moxy.MvpView

/**
 * Created by Umalt on 2/27/21
 */
abstract class BasePresenter<View : MvpView> : MvpPresenter<View>()