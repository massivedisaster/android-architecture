package com.daltinicchameleon.androidarchitecture.di.module

import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
abstract class FragmentBuilderModule {

}