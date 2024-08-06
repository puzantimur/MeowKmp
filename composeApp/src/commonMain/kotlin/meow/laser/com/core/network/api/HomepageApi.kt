package meow.laser.com.core.network.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import meow.laser.com.core.network.models.HomepageResponse

class HomepageApi(
    private val httpClient: HttpClient,
) {

    suspend fun fetchHomepage(): HomepageResponse {
        val response =  httpClient.get("/homepage")
        return response.body<HomepageResponse>()
    }
}