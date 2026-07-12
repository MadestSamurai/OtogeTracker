package com.madsam.otora.ui.record.osu.dialogs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.R
import com.madsam.otora.data.osu.ui.model.OsuTopRankUiModel
import com.madsam.otora.ui.record.osu.components.TopRankCard
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun TopRankDialog(
    title: String,
    topRankList: MutableStateFlow<List<OsuTopRankUiModel>>,
    onDismiss: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val data by topRankList.collectAsState()

    OsuExpandableBottomSheet(
        title = title,
        onDismiss = onDismiss
    ) { contentWidth ->
        if (data.isEmpty()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.osu_no_records_found),
                    color = colorScheme.onSurfaceVariant,
                    fontSize = 16.sp
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(6.dp))
            ) {
                items(
                    count = data.size,
                    key = { index -> data[index].scoreId }
                ) { index ->
                    TopRankCard(
                        item = data[index],
                        itemWidth = contentWidth
                    )
                    if (index != data.lastIndex) {
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}
