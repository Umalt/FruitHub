package com.umalt.fruithub.presentation.base.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Umalt on 2/26/21
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    open fun bind() {}
}