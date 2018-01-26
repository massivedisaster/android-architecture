package com.daltinicchameleon.androidarchitecture.di.module

import android.arch.persistence.room.Room
import com.daltinicchameleon.androidarchitecture.App
import com.daltinicchameleon.androidarchitecture.BuildConfig
import com.daltinicchameleon.androidarchitecture.api.ApiService
import com.daltinicchameleon.androidarchitecture.api.LiveDataCallaAdapterFactory
import com.daltinicchameleon.androidarchitecture.db.AppDatabase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by pedrookawa on 22/01/2018.
 */

@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideRequestInterceptor(): Interceptor {
        return Interceptor {
            chain ->
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url()

            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .build()

            val request = originalRequest
                    .newBuilder()
                    .url(url)
                    .build()

            chain.proceed(request)
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, requestInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(requestInterceptor)
                .connectTimeout(BuildConfig.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(BuildConfig.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(BuildConfig.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder().setDateFormat(BuildConfig.API_DATE_FORMAT).create()

    @Singleton
    @Provides
    fun provideLiveDataCallAdapterFactory() = LiveDataCallaAdapterFactory()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, liveDataCallaAdapterFactory: LiveDataCallaAdapterFactory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(liveDataCallaAdapterFactory)
                .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideAppDatabase(app: App) = Room.databaseBuilder(app, AppDatabase::class.java, "android_arch.db").build()

    @Singleton
    @Provides
    fun provideNearEarthObjectDao(appDatabase: AppDatabase) = appDatabase.nearEarthObjectDao()

}