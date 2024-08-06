package meow.laser.com.core.network.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createHttpClient(engine: HttpClientEngine, isAndroid: Boolean): HttpClient {
    return HttpClient(engine) {
        install(DefaultRequest) {
            url(urlString = if (isAndroid) "http://10.0.2.2:8080" else "http://0.0.0.0:8080")
        }
        install(Logging) {
            level = LogLevel.ALL

        }
        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }
}