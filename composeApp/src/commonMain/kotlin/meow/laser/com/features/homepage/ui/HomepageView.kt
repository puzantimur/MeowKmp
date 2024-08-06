package meow.laser.com.features.homepage.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import meow.composeapp.generated.resources.Res
import meow.composeapp.generated.resources.homepage_view_tab_man_title
import meow.composeapp.generated.resources.homepage_view_tab_woman_title
import meow.laser.com.theme.components.CustomTab
import meow.laser.com.theme.components.TabItem
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomepageView(
    uiState: HomepageUiState,
) {
    val tabItems = generateTabItem()
    val (selected, setSelected) = rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(top = 52.dp),
        ) {
            CustomTab(
                items = tabItems,
                selectedItemIndex = selected,
                onClick = setSelected,
            )
        }
        uiState.data?.let {
            if (selected == 0) {
                HomepageFeedView(data = it.womenTabData)
            } else {
                HomepageFeedView(data = it.menTabData)
            }
        }

    }
}

@Composable
fun generateTabItem(): List<TabItem> {
    return listOf(
        TabItem(stringResource(Res.string.homepage_view_tab_woman_title)),
        TabItem(stringResource(Res.string.homepage_view_tab_man_title))
    )
}