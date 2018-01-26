package com.daltinicchameleon.androidarchitecture.util.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView

/**
 * Created by pedrookawa on 24/01/2018.
 */

abstract class BasePagedListAdapter<T, VH: RecyclerView.ViewHolder>(diffCallback: DiffCallback<T>): PagedListAdapter<T, VH>(diffCallback) {

    abstract fun onBind(holder: VH, t: T)

    abstract fun onClear(holder: VH)

    override fun onBindViewHolder(holder: VH, position: Int) {
        val t = getItem(position)
        if (t != null) onBind(holder, t) else onClear(holder)
    }

}