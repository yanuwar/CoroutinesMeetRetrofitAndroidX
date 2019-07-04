package com.zanuwar.researchx.model

import com.google.gson.annotations.SerializedName


data class PlaceholderPosts (
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId : Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
) {
    override fun toString(): String {
        return title
    }
}
