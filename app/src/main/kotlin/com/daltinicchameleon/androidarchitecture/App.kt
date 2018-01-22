package com.daltinicchameleon.androidarchitecture

import com.daltinicchameleon.androidarchitecture.di.component.DaggerAppComponent
import dagger.android.support.DaggerApplication

/**
 * Created by pedrookawa on 22/01/2018.
 */
class App : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()
}