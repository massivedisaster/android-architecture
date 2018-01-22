package com.daltinicchameleon.androidarchitecture.ui.main

import android.os.Bundle
import com.daltinicchameleon.androidarchitecture.R
import com.daltinicchameleon.androidarchitecture.databinding.ActivityMainBinding
import com.daltinicchameleon.androidarchitecture.ui.common.BaseActivity

/**
 * Created by pedrookawa on 22/01/2018.
 */
class MainActivity: BaseActivity<ActivityMainBinding>() {

    override fun layoutToInflate() = R.layout.activity_main

    override fun doOnCreated() {

    }

    override fun doOnRestore(savedInstanceState: Bundle) {

    }
}