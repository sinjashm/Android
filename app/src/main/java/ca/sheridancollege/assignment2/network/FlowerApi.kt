package ca.sheridancollege.assignment2.network


import ca.sheridancollege.assignment2.data.Flower
import ca.sheridancollege.assignment2.data.FlowerPayload
import retrofit2.http.GET


interface FlowerApi {
    @GET("flowers.json")
    suspend fun getFlowers(): FlowerPayload

    companion object {
        const val BASE_URL =
            "https://tetervak.dev.fast.sheridanc.on.ca/mobile-app-data/flower-data/data/"
        const val IMAGE_BASE =
            "https://tetervak.dev.fast.sheridanc.on.ca/mobile-app-data/flower-data/images/flowers/"
    }
}