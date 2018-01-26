package com.daltinicchameleon.androidarchitecture.di.module

import com.daltinicchameleon.androidarchitecture.ui.feed.FeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeFeedFragment(): FeedFragment

}