package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Black333
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
import com.madsam.otora.core.utils.BrushUtils.getRatingTextColor
import com.madsam.otora.core.utils.BrushUtils.getRatingTextStrokeColor
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.LabeledRatingText
import com.madsam.otora.ui.record.chunithm.components.RatingValueText

private data class RatingPreviewItem(
    val label: String,
    val rating: String,
)

private val ratingPreviewItems = listOf(
    RatingPreviewItem("Green", "3.50"),
    RatingPreviewItem("Yellow", "6.50"),
    RatingPreviewItem("Red", "9.50"),
    RatingPreviewItem("Purple", "11.50"),
    RatingPreviewItem("Bronze", "12.50"),
    RatingPreviewItem("Silver", "13.50"),
    RatingPreviewItem("Gold", "14.80"),
    RatingPreviewItem("Platinum", "15.50"),
    RatingPreviewItem("Radiant", "16.50"),
    RatingPreviewItem("Lustrous", "17.50"),
)

@Composable
internal fun ChunithmRatingPreviewPage(
    viewModel: ChunithmViewModel,
) {
    val colorScheme = MaterialTheme.colorScheme
    val isDark = androidx.compose.foundation.isSystemInDarkTheme()

    DisposableEffect(viewModel) {
        viewModel.updatePageTitle("Rating 颜色预览")
        onDispose {
            viewModel.resetPageTitle()
        }
    }

    LazyColumn(
        modifier = Modifier
            .background(colorScheme.surface)
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item("tips") {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "用于对照 Chunithm 首页 Rating 文本效果",
                        color = colorScheme.onSurface,
                        fontFamily = plexBold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "主要调整位置：BrushUtils.getRatingTextColor / getRatingTextStrokeColor，以及 RatingText 的描边宽度。",
                        color = colorScheme.onSurfaceVariant,
                        fontFamily = plexRegular,
                        fontSize = 13.sp,
                        lineHeight = 18.sp
                    )
                }
            }
        }

        items(ratingPreviewItems, key = { it.rating }) { item ->
            RatingPreviewCard(
                item = item,
                isDark = isDark
            )
        }

        item("bottom_space") {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun RatingPreviewCard(
    item: RatingPreviewItem,
    isDark: Boolean,
) {
    val colorScheme = MaterialTheme.colorScheme
    val fillColor = getRatingTextColor(item.rating, isDark)
    val strokeColor = getRatingTextStrokeColor(item.rating, isDark)

    Card(
        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainerHigh),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = item.label,
                        color = colorScheme.onSurface,
                        fontFamily = plexBold,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "Rating ${item.rating}",
                        color = colorScheme.onSurfaceVariant,
                        fontFamily = plexRegular,
                        fontSize = 12.sp
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    ColorSwatch("Fill", fillColor)
                    ColorSwatch("Stroke", strokeColor)
                }
            }

            PreviewSurface(
                title = "主页卡片样式",
                backgroundColor = colorScheme.surfaceContainer,
                contentColor = colorScheme.onSurface,
                item = item
            )

            PreviewSurface(
                title = "深底对照",
                backgroundColor = Black333,
                contentColor = White1000,
                item = item
            )

            PreviewSurface(
                title = "浅底对照",
                backgroundColor = Color(0xFFF7F3EC),
                contentColor = Black333,
                item = item
            )
        }
    }
}

@Composable
private fun PreviewSurface(
    title: String,
    backgroundColor: Color,
    contentColor: Color,
    item: RatingPreviewItem,
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontFamily = plexRegular,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(backgroundColor)
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            LabeledRatingText(
                rating = item.rating,
                labelFontSize = 14.sp,
                ratingFontSize = 16.sp,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "独立数值",
                    color = contentColor.copy(alpha = 0.7f),
                    fontFamily = plexRegular,
                    fontSize = 12.sp
                )
                RatingValueText(
                    rating = item.rating,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Composable
private fun ColorSwatch(
    label: String,
    color: Color,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(width = 40.dp, height = 22.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(color)
        )
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontFamily = plexRegular,
            fontSize = 10.sp
        )
    }
}