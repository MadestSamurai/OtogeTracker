package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
import com.madsam.otora.core.utils.CalcUtils
import com.madsam.otora.core.utils.CalcUtils.numberToChuniRank
import com.madsam.otora.data.chunithm.ui.model.ChunithmSheetUiModel

data class SheetScoreInfo(
    val score: Int = 0,
    val rank: Int = 0,
    val clear: String = "",
    val combo: String = "",
    val chain: String = ""
)

@Composable
internal fun ChunithmSheetList(
    sheets: List<ChunithmSheetUiModel>,
    scoresMap: Map<String, SheetScoreInfo> = emptyMap()
) {
    val stds = sheets.filter { it.type == "std" }
    val wes = sheets.filter { it.type == "we" }
    
    // 检查基础四难度（BASIC, ADVANCED, EXPERT, MASTER）
    val basicDifficulties = listOf("basic", "advanced", "expert", "master")
    val basicSheets = stds.filter { it.difficulty in basicDifficulties }
    
    // 获取基础四难度的地区存在情况（作为参照）
    val basicRegionPattern = if (basicSheets.isNotEmpty()) {
        val firstBasic = basicSheets[0]
        Triple(firstBasic.cn, firstBasic.intl, firstBasic.jp)
    } else {
        Triple(false, false, false)
    }
    
    val stdRegions = if (stds.isNotEmpty()) listOf(
        Triple("CN", stds[0].cn, "cn"),
        Triple("Intl.", stds[0].intl, "intl"),
        Triple("JP", stds[0].jp, "jp")
    ) else listOf()

    Column {
        // 获取所有谱面并按地区存在情况分组
        val allSheets = stds + wes
        
        // 按地区存在情况分组
        val sheetGroups = mutableMapOf<Triple<Boolean, Boolean, Boolean>, MutableList<ChunithmSheetUiModel>>()
        
        allSheets.forEach { sheet ->
            val regionPattern = Triple(sheet.cn, sheet.intl, sheet.jp)
            if (!sheetGroups.containsKey(regionPattern)) {
                sheetGroups[regionPattern] = mutableListOf()
            }
            sheetGroups[regionPattern]!!.add(sheet)
        }
        
        // 按优先级排序分组：基础四难度优先，然后按地区存在情况排序
        val sortedGroups = sheetGroups.toList().sortedWith { (pattern1, sheets1), (pattern2, sheets2) ->
            // 检查是否包含基础四难度
            val basicDifficulties = listOf("basic", "advanced", "expert", "master")
            val group1HasBasic = sheets1.any { it.difficulty in basicDifficulties }
            val group2HasBasic = sheets2.any { it.difficulty in basicDifficulties }
            
            when {
                group1HasBasic && !group2HasBasic -> -1 // 基础四难度组优先
                !group1HasBasic && group2HasBasic -> 1
                else -> {
                    // 都有或都没有基础四难度，按地区存在情况排序
                    // CN > Intl > JP 的优先级
                    val score1 = (if (pattern1.first) 4 else 0) + (if (pattern1.second) 2 else 0) + (if (pattern1.third) 1 else 0)
                    val score2 = (if (pattern2.first) 4 else 0) + (if (pattern2.second) 2 else 0) + (if (pattern2.third) 1 else 0)
                    score2.compareTo(score1) // 降序排列
                }
            }
        }
        
        // 遍历每个分组
        sortedGroups.forEach { (regionPattern, sheetsInGroup) ->
            // 检查是否需要显示地区标识行
            val needsRegionHeader = regionPattern != basicRegionPattern
            
            if (needsRegionHeader) {
                // 显示该分组的地区标识行
                Row {
                    val regions = listOf(
                        Triple("CN", regionPattern.first, "cn"),
                        Triple("Intl.", regionPattern.second, "intl"),
                        Triple("JP", regionPattern.third, "jp")
                    )
                    regions.forEach { (tag, isActive, _) ->
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
            } else if (sheetsInGroup.any { listOf("basic", "advanced", "expert", "master").contains(it.difficulty) }) {
                // 这是基础四难度组，显示标准地区标识行
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
            }
            
            // 按难度类型和顺序排序该分组内的谱面
            val sortedSheetsInGroup = sheetsInGroup.sortedWith { sheet1, sheet2 ->
                val difficultyOrder = mapOf(
                    "basic" to 1, "advanced" to 2, "expert" to 3, "master" to 4, "ultima" to 5
                )
                
                when {
                    // 标准难度优先于WE难度
                    sheet1.type == "std" && sheet2.type == "we" -> -1
                    sheet1.type == "we" && sheet2.type == "std" -> 1
                    // 同类型按难度顺序
                    sheet1.type == "std" && sheet2.type == "std" -> {
                        (difficultyOrder[sheet1.difficulty] ?: 999) - (difficultyOrder[sheet2.difficulty] ?: 999)
                    }
                    // WE难度按字典序
                    else -> sheet1.difficulty.compareTo(sheet2.difficulty)
                }
            }
            
            // 显示该分组的所有谱面
            sortedSheetsInGroup.forEach { sheet ->
                val scoreInfo = scoresMap[sheet.difficulty] ?: SheetScoreInfo()
                
                if (sheet.type == "std") {
                    // 标准谱面
                    SheetDifficultyRow(sheet, scoreInfo)
                } else {
                    // World's End谱面
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(2.dp)
                    ) {
                        Text(
                            text = "${sheet.difficulty} ${sheet.levelJp}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = White1000,
                            modifier = Modifier
                                .clip(RoundedCornerShape(3.dp))
                                .background(CHUNI_DIFF_ULTIMA_1)
                                .padding(vertical = 2.dp, horizontal = 6.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        ScoreInfoRow(scoreInfo)
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun SheetDifficultyRow(
    sheet: ChunithmSheetUiModel,
    scoreInfo: SheetScoreInfo
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(2.dp)
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
    ) {
        Text(
            text = if (sheet.levelCn.isNotEmpty()) {
                "${sheet.levelValueCn}(CN) ${sheet.internalLevelValueJp}(JP)"
            } else {
                "${sheet.internalLevelValueJp}(JP)"
            },
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = White1000,
            modifier = Modifier
                .padding(vertical = 2.dp, horizontal = 6.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        ScoreInfoRow(scoreInfo)
        Spacer(modifier = Modifier.width(6.dp))
    }
}

@Composable
private fun ScoreInfoRow(scoreInfo: SheetScoreInfo) {
    if (scoreInfo.score > 0) {
        Text(
            text = scoreInfo.score.toString(),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = White1000,
            modifier = Modifier
                .clip(RoundedCornerShape(3.dp))
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(vertical = 1.dp, horizontal = 4.dp)
        )
        if (scoreInfo.rank >= 0) {
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = numberToChuniRank(scoreInfo.rank),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = White1000,
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(vertical = 1.dp, horizontal = 3.dp)
            )
        }
        if (scoreInfo.clear.isNotEmpty()) {
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = CalcUtils.clearToChuniClear(scoreInfo.clear),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = White1000,
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(vertical = 1.dp, horizontal = 3.dp)
            )
        }
        if (scoreInfo.combo.isNotEmpty()) {
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = CalcUtils.comboToChuniCombo(scoreInfo.combo),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = White1000,
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(vertical = 1.dp, horizontal = 3.dp)
            )
        }
        if (scoreInfo.chain.isNotEmpty()) {
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = CalcUtils.chainToChuniChain(scoreInfo.chain),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = White1000,
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(vertical = 1.dp, horizontal = 3.dp)
            )
        }
    }
}
