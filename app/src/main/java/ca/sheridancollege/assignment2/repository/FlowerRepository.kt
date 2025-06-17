package ca.sheridancollege.assignment2.repository


import ca.sheridancollege.assignment2.data.Flower
import ca.sheridancollege.assignment2.network.FlowerApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlowerRepository @Inject constructor(
    private val api: FlowerApi
) {
    suspend fun loadFlowers(): List<Flower> = api.getFlowers().flowers
}