package com.umalt.fruithub.utils

import android.content.res.Resources

/**
 * Created by Umalt on 2/28/21
 */
fun Int.toPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}