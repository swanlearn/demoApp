package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServiceList(
    @Json(name = "data")
    val serviceList : MutableList<Service>
)
