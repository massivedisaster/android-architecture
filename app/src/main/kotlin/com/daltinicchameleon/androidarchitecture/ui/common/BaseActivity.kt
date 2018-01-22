package com.daltinicchameleon.androidarchitecture.ui.common

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by pedrookawa on 22/01/2018.
 */

abstract class BaseActivity<out T: ViewDataBinding>: DaggerAppCompatActivity() {

    val dataBinding: T by lazy {
        DataBindingUtil.setContentView<T>(this, layoutToInflate())
    }

    @LayoutRes abstract fun layoutToInflate(): Int

    abstract fun doOnCreated()

    abstract fun doOnRestore(savedInstanceState: Bundle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        doOnCreated()

        val bundle = savedInstanceState ?: return
        doOnRestore(bundle)
    }


}