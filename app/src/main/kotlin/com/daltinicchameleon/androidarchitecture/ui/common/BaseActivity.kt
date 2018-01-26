package com.daltinicchameleon.androidarchitecture.ui.common

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import com.daltinicchameleon.androidarchitecture.R
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by pedrookawa on 22/01/2018.
 */

abstract class BaseActivity<T: ViewDataBinding>: DaggerAppCompatActivity() {

    lateinit var dataBinding: T

    @LayoutRes abstract fun layoutToInflate(): Int

    @IdRes open fun containerId() = R.id.frmMainContainer

    abstract fun doOnCreated()

    abstract fun doOnRestore(savedInstanceState: Bundle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        defineDataBinding()
        doOnCreated()

        val bundle = savedInstanceState ?: return
        doOnRestore(bundle)
    }

    private fun defineDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, layoutToInflate())
    }

}