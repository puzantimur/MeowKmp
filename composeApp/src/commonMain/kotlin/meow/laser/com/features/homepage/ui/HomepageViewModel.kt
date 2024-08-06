package meow.laser.com.features.homepage.ui

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import meow.laser.com.base.BaseViewModel
import meow.laser.com.features.homepage.domain.models.HomepageData
import meow.laser.com.features.homepage.tea.handlers.HomepageStateHandler
import meow.laser.com.features.homepage.tea.msg.HomepageMsg
import meow.laser.com.features.homepage.tea.state.HomepageState

internal class HomepageViewModel(
    private val stateHandler: HomepageStateHandler,
) : BaseViewModel<HomepageState, HomepageMsg, HomepageUiState>(stateHandler) {

    init {
        sendMsg(HomepageMsg.StartHomepage)
    }

    override val uiState: Flow<HomepageUiState>
        get() = stateHandler
            .stateFlow
            .filterIsInstance<HomepageState>()
            .map(::mapState)

    override fun mapState(state: HomepageState): HomepageUiState {
        return when (state) {
            is HomepageState.None -> HomepageUiState()
            is HomepageState.Progress.Failed -> HomepageUiState()
            is HomepageState.Progress.Loaded -> HomepageUiState(data = state.data, isLoading = false)
            is HomepageState.Progress.Loading -> HomepageUiState()
        }
    }
}

data class HomepageUiState(
    val data: HomepageData? = null,
    val isLoading: Boolean = true,
)
