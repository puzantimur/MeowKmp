import androidx.compose.ui.window.ComposeUIViewController
import meow.laser.com.App
import meow.laser.com.expect.KoinInitializer
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController(
    configure = { KoinInitializer().init() }
) { App() }
