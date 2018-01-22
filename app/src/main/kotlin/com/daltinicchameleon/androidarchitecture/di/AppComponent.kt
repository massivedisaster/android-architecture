package com.daltinicchameleon.androidarchitecture.di

import com.daltinicchameleon.androidarchitecture.App
import dagger.BindsInstance
import dagger.Component

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Component(modules = arrayOf(AppModule::class))
class AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder
        fun build(): AppComponent
    }
}