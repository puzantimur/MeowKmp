package meow.laser.com.features.homepage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun HomepageScreen(
    viewModel: HomepageViewModel = koinViewModel<HomepageViewModel>()
) {
    val viewState by viewModel.uiState.collectAsState(HomepageUiState())
    HomepageView(viewState)
}
