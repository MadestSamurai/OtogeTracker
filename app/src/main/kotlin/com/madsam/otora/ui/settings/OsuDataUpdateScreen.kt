package com.madsam.otora.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.`Chevron-left`
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.data.osu.local.datastore.OsuConfigDataStore
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OsuDataUpdateScreen(
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val userState = remember { mutableStateOf("") }
    val modeState = remember { mutableStateOf("osu") }
    val isClicked = remember { mutableStateOf(false) }
    val items = remember { listOf("mania", "osu", "taiko", "fruits") }
    val scope = rememberCoroutineScope()
    
    // 加载已保存的配置
    LaunchedEffect(Unit) {
        val osuConfigDataStore = OsuConfigDataStore(context)
        val (userId, mode) = osuConfigDataStore.getConfig()
        userState.value = userId
        modeState.value = mode
    }

    val colorScheme = MaterialTheme.colorScheme
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
    ) {
        // 顶栏
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "osu! 数据更新",
                    fontFamily = sarasaBold,
                    color = colorScheme.onSurface
                )
            },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Fa.`Chevron-left`,
                        contentDescription = "返回",
                        tint = colorScheme.onSurface,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorScheme.surfaceContainer,
                scrolledContainerColor = Color.Unspecified, navigationIconContentColor = colorScheme.onSurface,
                titleContentColor = colorScheme.onSurface,
                actionIconContentColor = Color.Unspecified
            )
        )
        
        // 设置内容
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "用户设置",
                    color = colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontFamily = sarasaBold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 用户ID输入
                TextField(
                    value = userState.value,
                    onValueChange = { userState.value = it },
                    label = { 
                        Text(
                            "osu! 用户ID",
                            fontFamily = sarasaRegular,
                            color = colorScheme.onSurfaceVariant
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = colorScheme.onSurface,
                        unfocusedTextColor = colorScheme.onSurface,
                        focusedContainerColor = colorScheme.surface,
                        unfocusedContainerColor = colorScheme.surface,
                        focusedIndicatorColor = colorScheme.onSurface,
                        unfocusedIndicatorColor = colorScheme.outline
                    )
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 游戏模式选择
                Text(
                    text = "游戏模式",
                    color = colorScheme.onSurfaceVariant,
                    fontSize = 14.sp,
                    fontFamily = sarasaRegular
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                ExposedDropdownMenuBox(
                    expanded = isClicked.value,
                    onExpandedChange = { isClicked.value = it },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        value = modeState.value,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { 
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = isClicked.value
                            ) 
                        },
                        modifier = Modifier
                            .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable, true)
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = colorScheme.onSurface,
                            unfocusedTextColor = colorScheme.onSurface,
                            focusedContainerColor = colorScheme.surface,
                            unfocusedContainerColor = colorScheme.surface,
                            focusedIndicatorColor = colorScheme.onSurface,
                            unfocusedIndicatorColor = colorScheme.outline
                        )
                    )

                    ExposedDropdownMenu(
                        expanded = isClicked.value,
                        onDismissRequest = { isClicked.value = false }
                    ) {
                        items.forEach { mode ->
                            DropdownMenuItem(
                                text = { 
                                    Text(
                                        mode,
                                        fontFamily = sarasaRegular
                                    ) 
                                },
                                onClick = {
                                    modeState.value = mode
                                    isClicked.value = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // 保存设置按钮
                Button(
                    onClick = {
                        scope.launch {
                            val osuConfigDataStore = OsuConfigDataStore(context)
                            osuConfigDataStore.saveConfig(userState.value, modeState.value)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorScheme.onSurface,
                        contentColor = colorScheme.surfaceContainer
                    )
                ) {
                    Text(
                        "保存设置",
                        fontFamily = sarasaSemiBold
                    )
                }
            }
        }
    }
}
