package meow.laser.com.tea

typealias Dispatch<T> = suspend (T) -> Unit