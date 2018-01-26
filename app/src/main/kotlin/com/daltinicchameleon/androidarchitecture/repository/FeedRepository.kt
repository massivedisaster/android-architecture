package com.daltinicchameleon.androidarchitecture.repository

import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.daltinicchameleon.androidarchitecture.db.NearEarthObjectDao
import com.daltinicchameleon.androidarchitecture.util.FeedBoundaryCallback
import javax.inject.Inject

/**
 * Created by pedrookawa on 22/01/2018.
 */

class FeedRepository @Inject constructor(private val feedBoundaryCallback: FeedBoundaryCallback, private val nearEarthObjectDao: NearEarthObjectDao) {

    private val pagedListConfig: PagedList.Config by lazy {
        (PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(20)
                .build()
    }

    private val feedData = LivePagedListBuilder(nearEarthObjectDao.selectAll(), 20)
        //.setBackgroundThreadExecutor(Executors.newFixedThreadPool(5))
        .setBoundaryCallback(feedBoundaryCallback)
        .build()

    fun getFeedData() = feedData

}