package meow.laser.com.core.network.utils

/**
 * Монада [Either] создан, чтобы передать состояние, которое может находиться в одном из двух вариантов:
* [Either.Left] и [Either.Right]. Если Вы передаёте ошибку и результат, то ошибка должна быть [Either.Left],
* а результат [Either.Right]. Пример: `Either<NetworkError, LoadedUser>`.
*/
sealed class Either<out A, out B> {
    /** Левая ветвь. */
    data class Left<T>(val value: T) : Either<T, Nothing>()

    /** Правая ветвь. */
    data class Right<T>(val value: T) : Either<Nothing, T>()
}

/** Трансформация правой части. */
inline infix fun <A, B, C> Either<A, B>.map(f: (B) -> C): Either<A, C> = when (this) {
    is Either.Left -> this
    is Either.Right -> Either.Right(f(value))
}

/** Трансформация правой части. */
inline infix fun <A, B, C> Either<A, B>.flatMap(f: (B) -> Either<A, C>): Either<A, C> = when (this) {
    is Either.Left -> this
    is Either.Right -> f(value)
}

/** Трансформация левой части. */
inline infix fun <A, B, C> Either<A, C>.mapLeft(f: (A) -> B): Either<B, C> = when (this) {
    is Either.Left -> Either.Left(f(value))
    is Either.Right -> this
}

/** Трансформация левой части. */
inline infix fun <A, B, C> Either<A, B>.flatMapLeft(f: (A) -> Either<C, B>): Either<C, B> = when (this) {
    is Either.Left -> f(value)
    is Either.Right -> this
}

/** Трансформация левой и правой частей. */
inline fun <A, B, C, D> Either<A, B>.bimap(leftOperation: (A) -> C, rightOperation: (B) -> D): Either<C, D> =
    when (this) {
        is Either.Left -> Either.Left(leftOperation(value))
        is Either.Right -> Either.Right(rightOperation(value))
    }

/** Сведение обеих ветвей к единому результату [C]. */
inline fun <A, B, C> Either<A, B>.fold(ifLeft: (A) -> C, ifRight: (B) -> C): C = when (this) {
    is Either.Left -> ifLeft(value)
    is Either.Right -> ifRight(value)
}

/** При совпадающих типах можно просто взять результат. */
fun <A> Either<A, A>.take(): A =
    when (this) {
        is Either.Left -> value
        is Either.Right -> value
    }

/** Возвращает результат правой части или `null`. */
fun <A, B> Either<A, B>.leftOrNull(): A? =
    when (this) {
        is Either.Left -> value
        is Either.Right -> null
    }

/** Возвращает результат правой части или `null`. */
fun <A, B> Either<A, B>.rightOrNull(): B? =
    when (this) {
        is Either.Left -> null
        is Either.Right -> value
    }

/** @return Список правых, если все [Either] внутри `List` являются правыми, или первый [Either.Left]. */
fun <L, R> List<Either<L, R>>.firstLeftOrRightList(): Either<L, List<R>> {
    val result = ArrayList<R>()
    for (either in this) {
        either.fold(
            ifLeft = { return Either.Left(it) },
            ifRight = result::add
        )
    }
    return Either.Right(result)
}