package com.zanuwar.researchx.deps

import com.zanuwar.researchx.BaseApp
import com.zanuwar.researchx.PreferencesModule.PreferencesModule
import com.zanuwar.researchx.networking.NetworkFactory
import com.zanuwar.researchx.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkFactory::class, PreferencesModule::class])
interface Deps {
    fun inject(mainActivity: MainActivity)
    fun inject(baseApp: BaseApp)
}