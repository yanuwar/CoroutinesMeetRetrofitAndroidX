package com.zanuwar.researchx.networking

import com.zanuwar.researchx.model.PlaceholderPosts
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {
    @GET("posts")
    fun getPosts() : Deferred<Response<List<PlaceholderPosts>>>

//    @GET("/users")
//    fun getUsers() : Deferred<Response<List<PlaceholderUsers>>>
//
//    @GET("/photos")
//    fun getPhotos() : Deferred<Response<List<PlaceholderPhotos>>>
}