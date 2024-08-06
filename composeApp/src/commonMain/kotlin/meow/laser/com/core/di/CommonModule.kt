package meow.laser.com.core.di

import meow.laser.com.core.network.api.HomepageApi
import meow.laser.com.expect.client
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun commonModule() = module {
    single { client }
    factoryOf(::HomepageApi)
}