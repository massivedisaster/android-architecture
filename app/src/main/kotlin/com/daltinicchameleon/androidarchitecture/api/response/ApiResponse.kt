package com.daltinicchameleon.androidarchitecture.api.response

import retrofit2.Response
import java.io.IOException

/**
 * Created by pedrookawa on 22/01/2018.
 */

class ApiResponse<T> {

    var body: T? = null
    var code: Int = 0
    var errorMessage: String? = null

    constructor(throwable: Throwable?) {
        code = 500
        body = null
        errorMessage = throwable?.message
    }

    constructor(response: Response<T>?) {
        code = response?.code()!!

        if(isSuccessful()) {
            body = response.body()
            errorMessage = null
        } else {
            body = null
            if (response.errorBody() != null) {
                try {
                    errorMessage = response.errorBody()?.string()!!
                } catch (exception: IOException) {

                }
            }

            if (errorMessage == null || errorMessage!!.trim().isEmpty()) {
                errorMessage = response.message()
            }
        }

    }

    private fun isSuccessful() = code in 200..299

}