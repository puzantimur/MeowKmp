package meow.laser.com.features.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import meow.composeapp.generated.resources.Res
import meow.composeapp.generated.resources.homepage_view_tab_man_title
import meow.composeapp.generated.resources.homepage_view_tab_woman_title
import meow.laser.com.theme.MeowTheme
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomepageView(

) {
    Text("FUCK", modifier = Modifier.size(20.dp), color = MeowTheme.colors.errorContainer)
    val tabItems = generateTabItem()
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(selectedTabIndex) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(
                            text = tabItem.title
                        )
                    }
                )
            }
        }

    }


}

data class TabItem(val title: String)

@Composable
fun generateTabItem(): List<TabItem> {
    return listOf(
        TabItem(stringResource(Res.string.homepage_view_tab_woman_title)),
        TabItem(stringResource(Res.string.homepage_view_tab_man_title))
    )
}

