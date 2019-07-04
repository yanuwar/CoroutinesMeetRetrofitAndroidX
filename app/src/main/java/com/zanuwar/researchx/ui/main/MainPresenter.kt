package com.zanuwar.researchx.ui.main

import com.zanuwar.researchx.model.PlaceholderPosts
import com.zanuwar.researchx.model.response.PlaceholderPostsResponse
import com.zanuwar.researchx.networking.NetworkFactory
import com.zanuwar.researchx.networking.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainPresenter(private val mainView: MainView) {
    private val service = NetworkFactory.networkService

    fun getPost() {
        GlobalScope.launch(Dispatchers.Main) {
            val postRequest = service.getPosts()
            val response = postRequest.await()
            mainView.onGetPost(response)
        }
    }

    interface MainView {
        fun onGetPost(response: Response<List<PlaceholderPosts>>)
    }
}