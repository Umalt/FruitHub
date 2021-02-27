package com.umalt.fruithub.presentation.base.rv

/**
 * Created by Umalt on 2/26/21
 */
interface BaseRVItem {
    val itemViewType: Int

    fun getItemId(): Int
}