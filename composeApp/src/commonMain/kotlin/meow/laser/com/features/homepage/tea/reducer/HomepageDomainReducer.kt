package meow.laser.com.features.homepage.tea.reducer

import meow.laser.com.core.tea.Reducer
import meow.laser.com.features.homepage.tea.effect.HomepageEffect
import meow.laser.com.features.homepage.tea.msg.HomepageDomainMsg
import meow.laser.com.features.homepage.tea.msg.HomepageMsg
import meow.laser.com.features.homepage.tea.state.HomepageState

internal class HomepageDomainReducer : Reducer<HomepageState, HomepageMsg, HomepageEffect> {
    override fun invoke(
        state: HomepageState,
        msg: HomepageMsg
    ): Pair<HomepageState, Set<HomepageEffect>> {
        return when (state) {
            is HomepageState.None -> state to emptySet()
            is HomepageState.Progress.Loaded -> state to emptySet()
            is HomepageState.Progress.Loading -> reduce(state, msg)
            is HomepageState.Progress.Failed -> state to emptySet()
        }
    }

    private fun reduce(
        state: HomepageState.Progress.Loading,
        msg: HomepageMsg,
    ): Pair<HomepageState, Set<HomepageEffect>> {
        return when (msg) {
            is HomepageDomainMsg.HomepageLoadFailed -> HomepageState.Progress.Failed to emptySet()
            is HomepageDomainMsg.HomepageLoaded -> {
                HomepageState.Progress.Loaded(msg.data) to emptySet()
            }

            is HomepageMsg.StartHomepage -> state to emptySet()
        }
    }
}