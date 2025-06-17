package ca.sheridancollege.assignment2.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Flower(
    val id: String,
    @Json(name = "label")
    val name: String,
    val price: Double,
    val description: String,
    @Json(name = "picture")
    val image: String,
    val wiki: String
)
