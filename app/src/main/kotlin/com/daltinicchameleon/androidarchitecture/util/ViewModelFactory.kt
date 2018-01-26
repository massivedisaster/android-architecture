package com.daltinicchameleon.androidarchitecture.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Singleton
class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    private val TAG = ViewModelFactory::class.java.canonicalName

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]

        if(creator != null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        if(creator == null) throw IllegalArgumentException("$TAG - Invalid creator")

        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}