package com.daltinicchameleon.androidarchitecture.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.daltinicchameleon.androidarchitecture.di.key.ViewModelKey
import com.daltinicchameleon.androidarchitecture.ui.feed.FeedViewModel
import com.daltinicchameleon.androidarchitecture.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    abstract fun bindFeedViewModel(feedViewModel: FeedViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}