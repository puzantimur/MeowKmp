package meow.laser.com.expect

import android.content.Context
import meow.laser.com.core.di.commonModule
import meow.laser.com.data.di.networkModule
import meow.laser.com.features.homepage.di.homepageModule
import meow.laser.com.features.login.di.loginModule
import meow.laser.com.features.splash.di.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinInitializer(
    private val context: Context,
) {
    actual fun init() {
        startKoin {
            androidContext(context)
            modules(
                loginModule(),
                networkModule(),
                splashModule(),
                homepageModule(),
                commonModule(),
            )
        }
    }
}