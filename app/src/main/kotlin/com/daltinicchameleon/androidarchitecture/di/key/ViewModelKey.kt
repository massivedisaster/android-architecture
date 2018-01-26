package com.daltinicchameleon.androidarchitecture.di.key

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by pedrookawa on 22/01/2018.
 */

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class ViewModelKey (val value: KClass<out ViewModel>)
