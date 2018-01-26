package com.daltinicchameleon.androidarchitecture.util

import com.daltinicchameleon.androidarchitecture.BuildConfig
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by pedrookawa on 25/01/2018.
 */

class DateUtils @Inject constructor() {

    fun requestDayBeforeValue(date: Date) = requestDayBeforeValue(convertDateToString(date))

    fun requestDayBeforeValue(dateValue: String): String {
        val dateFormat = SimpleDateFormat(BuildConfig.API_DATE_FORMAT, Locale.US)
        try {
            val startDate = dateFormat.parse(dateValue)

            val calendar = Calendar.getInstance()
            calendar.time = startDate
            calendar.add(Calendar.DATE, -1)
            return dateFormat.format(calendar.time)
        } catch (exception: Exception) {
            throw exception
        }
    }

    fun convertDateToString(date: Date): String {
        val dateFormat = SimpleDateFormat(BuildConfig.API_DATE_FORMAT, Locale.US)
        return dateFormat.format(date)
    }

}