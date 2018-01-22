package com.daltinicchameleon.androidarchitecture.di.component

import com.daltinicchameleon.androidarchitecture.App
import com.daltinicchameleon.androidarchitecture.di.module.ActivityBuilderModule
import com.daltinicchameleon.androidarchitecture.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ActivityBuilderModule::class))
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder
        fun build(): AppComponent
    }
}