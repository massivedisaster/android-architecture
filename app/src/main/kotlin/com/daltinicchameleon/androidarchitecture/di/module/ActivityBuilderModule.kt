package com.daltinicchameleon.androidarchitecture.di.module

import com.daltinicchameleon.androidarchitecture.ui.main.MainActivity
import com.daltinicchameleon.androidarchitecture.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuilderModule::class))
    abstract fun contributeMainActivity(): MainActivity

}