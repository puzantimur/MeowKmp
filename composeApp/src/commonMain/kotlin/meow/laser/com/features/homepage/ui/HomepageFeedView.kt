package meow.laser.com.features.homepage.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import meow.laser.com.features.homepage.domain.models.HomepageSectionData

@Composable
fun HomepageFeedView(
    modifier: Modifier = Modifier,
    data: List<HomepageSectionData>,
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 12.dp),
        modifier = modifier,
    ) {
        items(data) {
            HomepageSectionView(data = it)
        }
    }

}