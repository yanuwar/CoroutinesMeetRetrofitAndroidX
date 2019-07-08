package com.zanuwar.researchx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zanuwar.researchx.PreferencesModule.PreferencesModule
import com.zanuwar.researchx.deps.DaggerDeps
import com.zanuwar.researchx.deps.Deps
import com.zanuwar.researchx.networking.NetworkFactory
import java.io.File

open class BaseApp: AppCompatActivity() {
    lateinit var deps: Deps

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cacheFile = File(cacheDir, "responses")
        deps = DaggerDeps
            .builder()
            .networkFactory(NetworkFactory(application, cacheFile))
            .preferencesModule(PreferencesModule(application))
            .build()
        deps.inject(this)
    }
}