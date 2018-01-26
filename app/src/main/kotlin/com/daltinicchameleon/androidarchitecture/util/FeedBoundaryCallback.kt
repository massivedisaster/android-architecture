package com.daltinicchameleon.androidarchitecture.util

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import com.daltinicchameleon.androidarchitecture.api.ApiService
import com.daltinicchameleon.androidarchitecture.api.response.ApiResponse
import com.daltinicchameleon.androidarchitecture.api.response.FeedResponse
import com.daltinicchameleon.androidarchitecture.db.NearEarthObjectDao
import com.daltinicchameleon.androidarchitecture.model.NearEarthObject
import java.util.*
import java.util.concurrent.Executors
import javax.inject.Inject

/**
 * Created by pedrookawa on 25/01/2018.
 */
class FeedBoundaryCallback @Inject constructor(private val apiService: ApiService, private val dateUtils: DateUtils, private val nearEarthObjectDao: NearEarthObjectDao) : PagedList.BoundaryCallback<NearEarthObject>() {

    private var apiResponseData: LiveData<ApiResponse<FeedResponse>>? = null
    private val feedListObserver = FeedListObserver()

    override fun onZeroItemsLoaded() {
        apiResponseData = apiService.feed(dateUtils.convertDateToString(Date()), dateUtils.requestDayBeforeValue(Date()))
        apiResponseData?.observeForever(feedListObserver)
    }

    override fun onItemAtEndLoaded(itemAtEnd: NearEarthObject) {
        apiResponseData = apiService.feed(dateUtils.requestDayBeforeValue(dateUtils.requestDayBeforeValue(itemAtEnd.date)), dateUtils.requestDayBeforeValue(itemAtEnd.date))
        apiResponseData?.observeForever(feedListObserver)
    }

    internal inner class FeedListObserver: Observer<ApiResponse<FeedResponse>> {

        override fun onChanged(t: ApiResponse<FeedResponse>?) {
            apiResponseData?.removeObserver(this)

            val result = ArrayList<NearEarthObject>()
            t?.body?.nearEarthObjects?.values!!.forEach { result.addAll(it) }
            result.forEach { it.date = t.body?.nearEarthObjects?.keys?.first()!! }
            val executor = Executors.newSingleThreadExecutor()

            executor.submit {
                nearEarthObjectDao.insert(result)
            }
        }

    }

}