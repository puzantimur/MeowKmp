package meow.laser.com.features.homepage.tea.msg

import meow.laser.com.features.homepage.domain.models.HomepageData

internal sealed class HomepageMsg {
    data object StartHomepage : HomepageMsg()
}

internal sealed class HomepageDomainMsg : HomepageMsg() {
    data class HomepageLoaded(
        val data: HomepageData,
    ) : HomepageDomainMsg()

    data class HomepageLoadFailed(
        val message: String
    ) : HomepageDomainMsg()
}