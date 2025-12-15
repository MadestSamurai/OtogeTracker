package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.data.chunithm.ui.model.PlayDataCategoryType

/**
 * PlayData 分类方式选择器
 * 用于在不同分类方式之间切换（难度/类型/版本/定数）
 */
@Composable
fun PlayDataCategorySelector(
    selectedType: PlayDataCategoryType,
    onTypeChange: (PlayDataCategoryType) -> Unit,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CategoryButton(
            text = "难度",
            isSelected = selectedType == PlayDataCategoryType.DIFFICULTY,
            onClick = { onTypeChange(PlayDataCategoryType.DIFFICULTY) }
        )
        CategoryButton(
            text = "类型",
            isSelected = selectedType == PlayDataCategoryType.GENRE,
            onClick = { onTypeChange(PlayDataCategoryType.GENRE) }
        )
        CategoryButton(
            text = "版本",
            isSelected = selectedType == PlayDataCategoryType.VERSION,
            onClick = { onTypeChange(PlayDataCategoryType.VERSION) }
        )
        CategoryButton(
            text = "定数",
            isSelected = selectedType == PlayDataCategoryType.LEVEL,
            onClick = { onTypeChange(PlayDataCategoryType.LEVEL) }
        )
    }
}

@Composable
private fun CategoryButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    Text(
        text = text,
        fontSize = 12.sp,
        fontFamily = sarasaBold,
        color = if (isSelected) White1000 else colorScheme.onSurface,
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(if (isSelected) colorScheme.surfaceContainer else colorScheme.surfaceContainerHigh.copy(alpha = 0.3f))
            .border(
                width = 1.dp,
                color = if (isSelected) colorScheme.surfaceContainer else colorScheme.onSurface.copy(alpha = 0.3f),
                shape = RoundedCornerShape(4.dp)
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 4.dp)
    )
}
