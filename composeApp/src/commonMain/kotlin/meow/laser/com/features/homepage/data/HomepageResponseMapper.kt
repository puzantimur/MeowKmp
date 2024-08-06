package meow.laser.com.features.homepage.data

import meow.laser.com.core.network.models.HomepageProcedureResponse
import meow.laser.com.core.network.models.HomepageResponse
import meow.laser.com.core.network.models.HomepageSectionResponse
import meow.laser.com.features.homepage.domain.models.HomepageData
import meow.laser.com.features.homepage.domain.models.HomepageProcedureCardData
import meow.laser.com.features.homepage.domain.models.HomepageSectionData

fun HomepageResponse.mapToDomain() : HomepageData {
    return HomepageData(
        womenTabData = this.womanTab.map { it.mapToDomain() },
        menTabData = this.manTab.map { it.mapToDomain() }
    )
}

fun HomepageSectionResponse.mapToDomain() : HomepageSectionData {
    return HomepageSectionData(
        category = this.title,
        procedureCards = this.procedures.map { it.mapToDomain() }
    )
}

fun HomepageProcedureResponse.mapToDomain() : HomepageProcedureCardData {
    return HomepageProcedureCardData(
        procedureTitle = this.title,
        price = this.price,
        cover = this.cover
    )
}