package meow.laser.com.features.homepage.tea.reducer

import meow.laser.com.features.homepage.tea.effect.HomepageEffect
import meow.laser.com.features.homepage.tea.msg.HomepageMsg
import meow.laser.com.features.homepage.tea.state.HomepageState
import meow.laser.com.core.tea.Reducer
import meow.laser.com.features.homepage.tea.msg.HomepageDomainMsg

internal class HomepageReducer(
    private val homepageDomainReducer: HomepageDomainReducer,
) : Reducer<HomepageState, HomepageMsg, HomepageEffect> {
    override fun invoke(
        state: HomepageState,
        msg: HomepageMsg
    ): Pair<HomepageState, Set<HomepageEffect>> {
        return when (msg) {
            HomepageMsg.StartHomepage -> {
                when (state) {
                    HomepageState.None -> {
                        HomepageState.Progress.Loading to setOf(HomepageEffect.LoadHomepage)
                    }
                    is HomepageState.Progress -> state to setOf(HomepageEffect.LoadHomepage)
                }
            }

            is HomepageDomainMsg -> homepageDomainReducer.invoke(state, msg)
        }
    }
}