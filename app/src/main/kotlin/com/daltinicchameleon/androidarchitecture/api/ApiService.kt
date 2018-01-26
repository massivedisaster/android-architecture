package com.daltinicchameleon.androidarchitecture.api

import android.arch.lifecycle.LiveData
import com.daltinicchameleon.androidarchitecture.api.response.ApiResponse
import com.daltinicchameleon.androidarchitecture.api.response.FeedResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by pedrookawa on 22/01/2018.
 */

interface ApiService {

    @GET("feed")
    fun feed(@Query("start_date") startDate: String, @Query("end_date") endDate: String): LiveData<ApiResponse<FeedResponse>>

}