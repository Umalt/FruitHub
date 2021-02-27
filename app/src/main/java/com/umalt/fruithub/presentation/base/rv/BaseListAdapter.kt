package com.umalt.fruithub.presentation.base.rv

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by Umalt on 2/26/21
 */
abstract class BaseListAdapter<D : BaseRVItem, VH : BaseViewHolder> constructor(
    callback: DiffUtil.ItemCallback<D> = DiffUtilCallback()
) : ListAdapter<D, VH>(callback) {

    var onClickListener: OnClickListener? = null

    var onCheckedChangedListener: OnCheckedChangedListener? = null

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind()
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).itemViewType
    }

    fun update(list: List<D>) {
        this.submitList(ArrayList(list))
    }

    interface OnClickListener {
        fun onClick(view: View, position: Int)
    }

    interface OnCheckedChangedListener {
        fun onCheckedChange(position: Int, checked: Boolean)
    }
}

class DiffUtilCallback<D : BaseRVItem> : DiffUtil.ItemCallback<D>() {
    override fun areItemsTheSame(oldItem: D, newItem: D): Boolean {
        return oldItem.getItemId() == newItem.getItemId()
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: D, newItem: D): Boolean {
        return oldItem == newItem
    }
}