package com.daltinicchameleon.androidarchitecture.ui.common

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

/**
 * Created by pedrookawa on 22/01/2018.
 */

abstract class BaseFragment<T: ViewDataBinding>: DaggerFragment() {

    lateinit var dataBinding: T

    @LayoutRes abstract fun layoutToInflate(): Int

    abstract fun doOnCreated()

    abstract fun doOnRestore(savedInstanceState: Bundle)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(layoutInflater, layoutToInflate(), null, false)

        val view = dataBinding.root

        doOnCreated()

        val bundle = savedInstanceState ?: return view
        doOnRestore(bundle)

        return view
    }

}