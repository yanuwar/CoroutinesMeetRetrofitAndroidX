package com.zanuwar.researchx

import android.app.Application
import android.content.Context

class MainApp: Application() {
    private var instance: MainApp? = null

    fun getInstance(): MainApp? {
        return instance
    }

    fun getContext(): Context? {
        return instance
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}