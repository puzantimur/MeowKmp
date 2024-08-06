package meow.laser.com.features.homepage.domain.models

data class HomepageSectionData(
    val category: String,
    val procedureCards: List<HomepageProcedureCardData>,
)