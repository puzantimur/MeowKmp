package meow.laser.com.features.splash.di

import org.koin.core.Koin
import org.koin.core.module.Module

internal object SplashScreenModuleController {
    private var internalModules: List<Module>? = null

    fun loadModule(koin: Koin) {
        if (internalModules == null) {
            internalModules = listOf(splashModule())
            internalModules?.let(koin::loadModules)
        }
    }

    fun unloadModule(koin: Koin) {
        internalModules?.let(koin::unloadModules)
        internalModules = null
    }
}
