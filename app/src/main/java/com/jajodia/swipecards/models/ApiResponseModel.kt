package com.jajodia.swipecards.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponseModel(
    @Json(name = "data") val data: List<DataModel>
)

@JsonClass(generateAdapter = true)
data class DataModel(
    @Json(name = "id") val id: String,
    @Json(name = "text") val text: String
)