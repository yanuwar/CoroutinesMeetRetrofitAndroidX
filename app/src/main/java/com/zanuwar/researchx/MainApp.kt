package com.zanuwar.researchx

import android.app.Application
import android.content.Context

class MainApp: Application() {
    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {
        var instance: MainApp? = null
            private set
    }
}