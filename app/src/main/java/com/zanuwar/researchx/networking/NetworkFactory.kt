package com.zanuwar.researchx.networking

import android.app.Application
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import com.zanuwar.researchx.BuildConfig
import com.zanuwar.researchx.PreferencesModule.PreferencesUtil
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
class NetworkFactory(private val application: Application, internal var cacheFile: File) {
    @Provides
    @Singleton
    internal fun provideCall(preferencesUtil: PreferencesUtil): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val client =
            OkHttpClient().newBuilder()
                .addInterceptor(ChuckInterceptor(application.applicationContext))
                .addInterceptor(httpLoggingInterceptor)
                .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun providesNetworkService(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }
}