package meow.laser.com.tea

/**
 * Функциональный интерфейс с логикой по трансформации состояния в ответ на пришедшее действие [Msg].
* Также возвращает набор [Effect], которые являются побочными действиями, необходимыми для выполнения.
*/
fun interface Reducer<State : Any, in Msg : Any, out Effect : Any> {
    operator fun invoke(state: State, msg: Msg): Pair<State, Set<Effect>>
}