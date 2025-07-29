package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.data.chunithm.ui.model.ChunithmSheetUiModel
import com.madsam.otora.ui.BASE_URL
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.ChunithmSheetList

@Composable
internal fun ChunithmSongDetailPage(
    songTitle: String,
    viewModel: ChunithmViewModel,
    onNavigateBack: () -> Unit
) {
    // 对URL编码的标题进行解码
    val decodedTitle = java.net.URLDecoder.decode(songTitle, "UTF-8")
    
    val songList by viewModel.chuniSongs.collectAsState()
    val song = songList.find { it.title == decodedTitle }

    if (song == null) {
        // 如果找不到歌曲，显示错误页面
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Red300)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "歌曲未找到",
                color = Beige500,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        return
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 封面和基本信息
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Red500),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top
                    ) {
                        // 封面图片
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = "$BASE_URL/chuni/img/${song.imageName}",
                                contentScale = ContentScale.Crop
                            ),
                            contentDescription = "封面",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        // 基本信息
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = song.title,
                                color = White1000,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            InfoRow("艺术家", song.artist)
                            InfoRow("版本", song.version)
                            InfoRow("类型", song.genre)
                            if (song.bpm > 0) {
                                InfoRow("BPM", song.bpm.toString())
                            }
                        }
                    }
                }
            }
        }

        // 难度信息和成绩
        if (song.sheets.isNotEmpty()) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Red500),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "难度信息与成绩",
                            color = Beige400,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        // 使用 ChunithmSheetList 组件
                        val scoresMap = viewModel.getSheetScoreInfoMapForSong(song.title)
                        ChunithmSheetList(
                            sheets = song.sheets,
                            scoresMap = scoresMap
                        )
                    }
                }
            }
        }

        // 详细难度信息
        items(song.sheets.size) { index ->
            SongSheetDetailCard(sheet = song.sheets[index])
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label:",
            color = Beige400,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(0.4f)
        )
        Text(
            text = value,
            color = White1000,
            fontSize = 14.sp,
            modifier = Modifier.weight(0.6f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun SongSheetDetailCard(sheet: ChunithmSheetUiModel) {
    val difficultyColor = when (sheet.difficulty) {
        "basic" -> CHUNI_DIFF_BASIC
        "advanced" -> CHUNI_DIFF_ADVANCED
        "expert" -> CHUNI_DIFF_EXPERT
        "master" -> CHUNI_DIFF_MASTER
        "ultima" -> CHUNI_DIFF_ULTIMA_1
        else -> Red300
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = difficultyColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // 难度标题行
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = sheet.difficulty.uppercase(),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Lv. ${sheet.levelCn}",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            if (sheet.difficulty == "ultima") {
                Spacer(modifier = Modifier.height(1.dp))
                androidx.compose.foundation.Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                ) {
                    drawRect(CHUNI_DIFF_ULTIMA_2)
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 难度数值信息
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    if (sheet.levelCn.isNotEmpty()) {
                        Text(
                            text = "CN: ${sheet.levelCn}",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "定数: ${sheet.levelValueCn}",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (sheet.levelJp.isNotEmpty()) {
                        Text(
                            text = "JP: ${sheet.levelJp}",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "内部定数: ${sheet.internalLevelValueJp}",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                    }
                }
                
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Total: ${sheet.total}",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    if (sheet.noteDesigner.isNotEmpty()) {
                        Text(
                            text = "谱面: ${sheet.noteDesigner}",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                    }
                }
            }
            
            // 音符统计
            if (sheet.total > 0) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "音符统计",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    NoteTypeItem("TAP", sheet.tap)
                    NoteTypeItem("HOLD", sheet.hold)
                    NoteTypeItem("SLIDE", sheet.slide)
                    NoteTypeItem("AIR", sheet.air)
                    NoteTypeItem("FLICK", sheet.flick)
                }
            }
        }
    }
}

@Composable
private fun NoteTypeItem(type: String, count: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = type,
            color = White1000.copy(alpha = 0.7f),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = count.toString(),
            color = White1000,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
