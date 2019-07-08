package com.zanuwar.researchx.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zanuwar.researchx.BaseApp
import com.zanuwar.researchx.PreferencesModule.PreferencesUtil
import com.zanuwar.researchx.R
import com.zanuwar.researchx.model.PlaceholderPosts
import com.zanuwar.researchx.networking.NetworkFactory
import com.zanuwar.researchx.networking.NetworkService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import retrofit2.Response
import javax.inject.Inject

class MainActivity : BaseApp(), MainPresenter.MainView {
    private lateinit var presenter: MainPresenter

    @Inject
    lateinit var service: NetworkService
    @Inject
    lateinit var preferencesUtil: PreferencesUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        deps.inject(this)

        //init presenter
        presenter = MainPresenter(this)
        //calling getPost
        presenter.getPost(service)
    }

    override fun onGetPost(response: Response<List<PlaceholderPosts>>) {
        tv_result?.text = response.toString()
    }
}
