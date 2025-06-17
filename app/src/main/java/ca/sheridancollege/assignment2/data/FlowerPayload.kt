package ca.sheridancollege.assignment2.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlowerPayload(
    @Json(name = "flowers")
    val flowers: List<Flower>)