package meow.laser.com.expect

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import meow.laser.com.core.network.client.createHttpClient

actual val client: HttpClient = createHttpClient(OkHttp.create(), true)