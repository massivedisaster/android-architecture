package com.daltinicchameleon.androidarchitecture.ui.splash

import android.os.Bundle
import com.daltinicchameleon.androidarchitecture.util.NavigationManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by pedrookawa on 22/01/2018.
 */

class SplashActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigationManager.openMain(this)
    }

}