package com.daltinicchameleon.androidarchitecture.ui.feed

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.daltinicchameleon.androidarchitecture.R
import com.daltinicchameleon.androidarchitecture.databinding.FragmentFeedBinding
import com.daltinicchameleon.androidarchitecture.model.NearEarthObject
import com.daltinicchameleon.androidarchitecture.ui.common.BaseFragment
import com.daltinicchameleon.androidarchitecture.util.ViewModelFactory
import com.daltinicchameleon.androidarchitecture.util.adapter.FeedAdapter
import javax.inject.Inject

/**
 * Created by pedrookawa on 22/01/2018.
 */
class FeedFragment: BaseFragment<FragmentFeedBinding>() {

    companion object {
        fun instance(): FeedFragment {
            val fragment = FeedFragment()
            return fragment
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var feedAdapter = FeedAdapter()
    private lateinit var feedViewModel: FeedViewModel

    override fun layoutToInflate() = R.layout.fragment_feed

    override fun doOnCreated() {
        feedViewModel = ViewModelProviders.of(this, viewModelFactory).get(FeedViewModel::class.java)

        dataBinding.rclFeedContent.layoutManager = LinearLayoutManager(context)
        dataBinding.rclFeedContent.adapter = feedAdapter

        feedViewModel.getFeedData().observe(this, Observer<PagedList<NearEarthObject>> {
            nearEarthObjectList ->
            feedAdapter.setList(nearEarthObjectList)
        })
    }

    override fun doOnRestore(savedInstanceState: Bundle) {

    }

}