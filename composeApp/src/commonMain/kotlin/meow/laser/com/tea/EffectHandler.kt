package meow.laser.com.tea

/**
 * Effect - некоторое изменение внешней среды. То есть поход в сеть, запрос в базу,
* даже println по сути является эффектом. Наши effect handler-ы реимущественно ходят в сценарии/юзкейсы и
* возвращают результат в виде [Msg].
* Подсвечу, что эффект может отправлять [Msg] любое количество раз, от 0 до бесконечности.
* Примеры:
* ```
* dispatch(Loading(percent=0)
* repeat(100) {
*     delay(100)
*     dispatch(Loading(percent=it))
* }
* ```
*/
fun interface EffectHandler<in Effect, out Msg> {
    suspend operator fun invoke(effect: Effect, dispatch: Dispatch<Msg>)
}