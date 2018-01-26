package com.daltinicchameleon.androidarchitecture.api

import android.arch.lifecycle.LiveData
import com.daltinicchameleon.androidarchitecture.api.response.ApiResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by pedrookawa on 22/01/2018.
 */

class LiveDataCallAdapter<T>(private val responseType: Type): CallAdapter<T, LiveData<ApiResponse<T>>> {

    override fun adapt(call: Call<T>?): LiveData<ApiResponse<T>> {
        return object: LiveData<ApiResponse<T>>() {
            internal val started = AtomicBoolean()

            override fun onActive() {
                super.onActive()

                if (started.compareAndSet(false, true)) {
                    call?.enqueue(object: Callback<T> {
                        override fun onFailure(call: Call<T>?, t: Throwable?) {
                            postValue(ApiResponse(t))
                        }

                        override fun onResponse(call: Call<T>?, response: Response<T>?) {
                            postValue(ApiResponse(response))
                        }
                    })
                }
            }
        }
    }

    override fun responseType() = responseType
}