package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.BG_DARK_GRAY
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Black333
import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.data.chunithm.ui.model.ChunithmSheetUiModel

@Composable
internal fun ChunithmSheetList(
    sheets: List<ChunithmSheetUiModel>,
    lineWidth: Dp
) {
    val stds = sheets.filter { it.type == "std" }
    val wes = sheets.filter { it.type == "we" }
    val stdRegions = listOf(
        Triple("CN", stds[0].cn, "cn"),
        Triple("Intl.", stds[0].intl, "intl"),
        Triple("JP", stds[0].jp, "jp")
    )
    Column {
        Row {
            stdRegions.forEach { (tag, isActive, _) ->
                Text(
                    text = tag,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isActive) Beige500 else Black333,
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(if (isActive) Red500 else BG_DARK_GRAY)
                        .padding(vertical = 2.dp, horizontal = 6.dp)
                )
            }
        }
        for (sheet in stds) {
            Text(
                text = if (sheet.levelCn.isNotEmpty()) {
                    "${sheet.levelValueCn}(CN) ${sheet.levelValueJp}(JP)"
                } else {
                    "${sheet.levelValueJp}(JP)"
                },
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = White1000,
                modifier = Modifier
                    .padding(2.dp)
                    .width(lineWidth)
                    .clip(RoundedCornerShape(3.dp))
                    .background(
                        when (sheet.difficulty) {
                            "basic" -> CHUNI_DIFF_BASIC
                            "advanced" -> CHUNI_DIFF_ADVANCED
                            "expert" -> CHUNI_DIFF_EXPERT
                            "master" -> CHUNI_DIFF_MASTER
                            "ultima" -> CHUNI_DIFF_ULTIMA_1
                            else -> CHUNI_DIFF_ULTIMA_1
                        }
                    )
                    .border(
                        width = if (sheet.difficulty == "ultima") 1.dp else 0.dp,
                        color = if (sheet.difficulty == "ultima") CHUNI_DIFF_ULTIMA_2 else Color.Transparent,
                        shape = RoundedCornerShape(3.dp)
                    )
                    .padding(vertical = 2.dp, horizontal = 6.dp)
            )
        }
        for (sheet in wes) {
            val weRegions = listOf(
                Triple("CN", sheet.cn, "cn"),
                Triple("Intl.", sheet.intl, "intl"),
                Triple("JP", sheet.jp, "jp")
            )
            Row {
                weRegions.forEach { (tag, isActive, _) ->
                    Text(
                        text = tag,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isActive) Beige500 else Black333,
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(if (isActive) Red500 else BG_DARK_GRAY)
                            .padding(vertical = 2.dp, horizontal = 6.dp)
                    )
                }
            }
            Text(
                text = "${sheet.difficulty} ${sheet.levelJp}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = White1000,
                modifier = Modifier
                    .padding(2.dp)
                    .width(lineWidth)
                    .clip(RoundedCornerShape(3.dp))
                    .background(CHUNI_DIFF_ULTIMA_1)
                    .padding(vertical = 2.dp, horizontal = 6.dp)
            )
        }
    }
}
