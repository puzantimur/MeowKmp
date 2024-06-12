import androidx.compose.ui.window.ComposeUIViewController
import meow.laser.com.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
