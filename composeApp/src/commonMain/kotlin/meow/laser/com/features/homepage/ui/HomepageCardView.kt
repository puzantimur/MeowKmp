package meow.laser.com.features.homepage.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import meow.composeapp.generated.resources.Aboreto_Regular
import meow.composeapp.generated.resources.Res
import meow.laser.com.features.homepage.domain.models.HomepageProcedureCardData
import meow.laser.com.features.homepage.domain.models.HomepageSectionData
import meow.laser.com.theme.MeowTheme
import meow.laser.com.theme.components.MeowSpacer
import meow.laser.com.theme.components.TextStyles
import org.jetbrains.compose.resources.Font

@Composable
fun HomepageSectionView(
    modifier: Modifier = Modifier,
    data: HomepageSectionData,
) {
    Column(
        modifier = modifier.padding(vertical = 12.dp)
    ) {
        MeowSpacer(8.dp)

        Text(
            modifier = Modifier.padding(start = 18.dp),
            text = data.category,
            style = TextStyles.mainTitle,
            fontFamily = FontFamily(Font(Res.font.Aboreto_Regular)),
            color = MeowTheme.colors.onSurfaceVariant,
        )

        LazyRow(
            contentPadding = PaddingValues(8.dp)
        ) {
            items(data.procedureCards) {
                HomepageCardView(cardData = it)
            }
        }
    }
}

@Composable
fun HomepageCardView(
    modifier: Modifier = Modifier,
    cardData: HomepageProcedureCardData
) {
    Box(
        modifier = modifier
            .wrapContentWidth()
            .height(230.dp)
            .padding(12.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(color = MeowTheme.colors.secondaryContainer),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp, horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = cardData.procedureTitle,
                style = TextStyles.subTitle,
                fontFamily = FontFamily(Font(Res.font.Aboreto_Regular)),
                color = MeowTheme.colors.onSecondaryContainer,
            )

            MeowSpacer(12.dp)

            Text(
                text = "${cardData.price} zł",
                style = TextStyles.bodyM,
                fontFamily = FontFamily(Font(Res.font.Aboreto_Regular)),
                color = MeowTheme.colors.onSecondaryContainer
            )

            MeowSpacer(8.dp)

            AsyncImage(
                modifier = Modifier.size(120.dp).clip(CircleShape),
                model = cardData.cover,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}