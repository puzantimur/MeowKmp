package meow.laser.com.base.network

import io.ktor.utils.io.errors.*
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
    } catch (exception: IOException) {
        Either.Left(NetworkFailure.NoConnection(exception))
    } 
    