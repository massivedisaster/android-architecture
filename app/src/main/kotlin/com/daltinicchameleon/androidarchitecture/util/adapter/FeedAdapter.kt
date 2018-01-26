package com.daltinicchameleon.androidarchitecture.util.adapter

import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.daltinicchameleon.androidarchitecture.R
import com.daltinicchameleon.androidarchitecture.databinding.AdapterFeedBinding
import com.daltinicchameleon.androidarchitecture.model.NearEarthObject

/**
 * Created by pedrookawa on 24/01/2018.
 */

class FeedAdapter: BasePagedListAdapter<NearEarthObject, FeedAdapter.FeedViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object: DiffCallback<NearEarthObject>() {
            override fun areContentsTheSame(oldItem: NearEarthObject, newItem: NearEarthObject): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: NearEarthObject, newItem: NearEarthObject): Boolean {
                return oldItem.referenceId == newItem.referenceId
            }
        }
    }

    override fun onBind(holder: FeedViewHolder, t: NearEarthObject) {
        holder.dataBinding.nearEarthObject = t
    }

    override fun onClear(holder: FeedViewHolder) {

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FeedViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val view = layoutInflater.inflate(R.layout.adapter_feed, parent, false)

        val dataBinding: AdapterFeedBinding = DataBindingUtil.bind(view)

        return FeedViewHolder(dataBinding)
    }

    class FeedViewHolder(val dataBinding: AdapterFeedBinding): RecyclerView.ViewHolder(dataBinding.root)

}