package com.daltinicchameleon.androidarchitecture.ui.feed

import android.arch.lifecycle.ViewModel
import com.daltinicchameleon.androidarchitecture.repository.FeedRepository
import javax.inject.Inject

/**
 * Created by pedrookawa on 22/01/2018.
 */

class FeedViewModel @Inject constructor(private val feedRepository: FeedRepository): ViewModel() {

    fun getFeedData() = feedRepository.getFeedData()

}