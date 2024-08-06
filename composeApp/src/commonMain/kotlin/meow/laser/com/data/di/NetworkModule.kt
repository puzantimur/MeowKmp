package meow.laser.com.data.di

import io.ktor.client.HttpClient
import meow.laser.com.data.api.LoginApi
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun networkModule() = module {
    single {
        HttpClient {


        }
    }
    singleOf(::LoginApi)
}