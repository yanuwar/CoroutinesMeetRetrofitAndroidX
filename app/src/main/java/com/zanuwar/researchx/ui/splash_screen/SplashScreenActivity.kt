package com.zanuwar.researchx.ui.splash_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zanuwar.researchx.BaseApp
import com.zanuwar.researchx.R

class SplashScreenActivity : BaseApp() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }
}
