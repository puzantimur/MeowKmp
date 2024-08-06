package meow.laser.com.features.homepage.tea.state

import meow.laser.com.features.homepage.domain.models.HomepageData

internal sealed interface HomepageState {

    data object None : HomepageState

    sealed class Progress : HomepageState {
        data object Loading : Progress()
        data class Loaded(
            val data : HomepageData
        ) : Progress()
        data object Failed : Progress()
    }
}