package meow.laser.com.features.splash.di

import meow.laser.com.features.splash.ui.SplashViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun splashModule() = module {
    singleOf(::SplashViewModel)
}

