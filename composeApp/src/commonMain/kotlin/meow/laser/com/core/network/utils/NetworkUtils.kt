package meow.laser.com.core.network.utils

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.Serializable

typealias NetworkResponse<T> = Either<NetworkFailure, T>

@Serializable
/** Ошибка при сетевом запросе. */
sealed class NetworkFailure {

    /** Возможная причина возникновения ошибки. */
    abstract val exception: Exception?

    /** Нет соединения с интернетом. */
    class NoConnection(override val exception: Exception) : NetworkFailure() {

        override fun toString(): String =
            "NoConnection(exception=$exception)"
    }

    /** Не 2xx ответ от сервера. */
    class HttpFailure(
        val code: Int,
        val message: String,
        override val exception: Exception?,
    ) : NetworkFailure() {

        override fun equals(other: Any?): Boolean =
            other is HttpFailure
                    && code == other.code
                    && message == other.message

        override fun hashCode(): Int {
            var result = 31 * message.hashCode() + code
            result = 31 * result + (exception?.stackTraceToString().hashCode())
            return result
        }

        override fun toString(): String =
            "HttpFailure(code=$code, message=$message, exception=$exception)"
    }
}

/** Безопасная обёртка для сетевых запросов. */
inline fun <T> networkRequest(block: () -> T): NetworkResponse<T> =
    try {
        Either.Right(block())
    } catch (exception: ClientRequestException) {
        Either.Left(
            NetworkFailure.HttpFailure(
                code = exception.response.status.value,
                message = exception.message,
                exception = exception
            )
        )
    } catch (exception: ServerResponseException) {
        Either.Left(
            NetworkFailure.HttpFailure(
                code = exception.response.status.value,
                message = exception.message,
                exception = exception
            )
        )
    } catch (exception: IOException) {
        Either.Left(NetworkFailure.NoConnection(exception))
    }