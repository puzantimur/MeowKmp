package meow.laser.com.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class HomepageResponse(
    val womanTab: List<HomepageSectionResponse>,
    val manTab: List<HomepageSectionResponse>,
)

@Serializable
data class HomepageSectionResponse(
    val title: String,
    val procedures: List<HomepageProcedureResponse>,
)

@Serializable
data class HomepageProcedureResponse(
    val title: String,
    val price: Double,
    val cover: String,
)