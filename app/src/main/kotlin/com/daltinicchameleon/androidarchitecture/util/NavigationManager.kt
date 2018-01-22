package com.daltinicchameleon.androidarchitecture.util

import android.app.Activity
import android.content.Intent
import com.daltinicchameleon.androidarchitecture.ui.main.MainActivity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Singleton
class NavigationManager @Inject constructor() {

    fun openMain(activity: Activity) {
        val intent = Intent(activity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        activity.startActivity(intent)
    }

}