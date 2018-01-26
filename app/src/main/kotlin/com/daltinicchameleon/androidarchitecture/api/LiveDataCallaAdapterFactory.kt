package com.daltinicchameleon.androidarchitecture.api

import android.arch.lifecycle.LiveData
import com.daltinicchameleon.androidarchitecture.api.response.ApiResponse
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by pedrookawa on 22/01/2018.
 */
class LiveDataCallaAdapterFactory: CallAdapter.Factory() {

    override fun get(returnType: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): CallAdapter<*, *>? {
        if(getRawType(returnType) != LiveData::class.java) return null

        val observableType = getParameterUpperBound(0, returnType as ParameterizedType?)
        val rawObservableType = getRawType(observableType)

        if (rawObservableType != ApiResponse::class.java) throw IllegalArgumentException()
        if (observableType !is ParameterizedType) throw IllegalArgumentException()

        val bodyType = getParameterUpperBound(0, observableType)
        return LiveDataCallAdapter<Any>(bodyType)
    }
}