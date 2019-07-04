package com.zanuwar.researchx.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zanuwar.researchx.R
import com.zanuwar.researchx.model.PlaceholderPosts
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainPresenter.MainView {
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //init presenter
        presenter = MainPresenter(this)

        //calling getPost
        presenter.getPost()
    }

    override fun onGetPost(response: Response<List<PlaceholderPosts>>) {
        tv_result?.text = response.toString()
    }
}
