package com.daltinicchameleon.androidarchitecture

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by pedrookawa on 22/01/2018.
 */
class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}