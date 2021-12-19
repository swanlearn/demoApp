package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsList(
    @Json(name = "data")
    val newsList: MutableList<News>
)
