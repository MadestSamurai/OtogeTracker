package com.madsam.otora.ui.settings

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.madsam.otora.R
import com.madsam.otora.core.datastore.ThemeDataStore
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.`Chevron-down`
import com.madsam.otora.core.icon.fa.`Chevron-left`
import com.madsam.otora.core.icon.fa.`Chevron-up`
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
import com.madsam.otora.core.theme.plexSemi
import kotlinx.coroutines.launch

/**
 * 语言项数据类
 */
data class LanguageItem(
    val code: String,
    val displayNameResId: Int,
    val nativeName: String
)

/**
 * 语言设置页面
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSettingScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onLanguageChanged: (() -> Unit)? = null
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val themeDataStore = remember { ThemeDataStore(context) }
    val colorScheme = MaterialTheme.colorScheme
    
    // 从 DataStore 读取设置
    val followSystem by themeDataStore.getFollowSystemLanguageFlow().collectAsState(initial = true)
    val savedLanguageOrder by themeDataStore.getLanguageOrderFlow().collectAsState(initial = listOf("zh-CN", "en"))
    
    // 本地状态
    var isFollowSystem by remember { mutableStateOf(followSystem) }
    var languageOrder by remember { mutableStateOf(savedLanguageOrder) }
    
    // 同步 DataStore 数据
    LaunchedEffect(followSystem) {
        isFollowSystem = followSystem
    }
    LaunchedEffect(savedLanguageOrder) {
        languageOrder = savedLanguageOrder
    }
    
    // 所有可用语言
    val allLanguages = remember {
        listOf(
            LanguageItem("zh-CN", R.string.language_chinese_simplified, "简体中文"),
            LanguageItem("en", R.string.language_english, "English")
        )
    }
    
    // 根据保存的顺序排序语言列表
    val sortedLanguages = remember(languageOrder) {
        languageOrder.mapNotNull { code ->
            allLanguages.find { it.code == code }
        }
    }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorScheme.surface)
    ) {
        // 顶栏
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.language_select_title),
                    fontFamily = plexBold,
                    color = colorScheme.onSurface
                )
            },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Fa.`Chevron-left`,
                        contentDescription = stringResource(R.string.settings_back),
                        tint = colorScheme.onSurface,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorScheme.surfaceContainer,
                scrolledContainerColor = Color.Unspecified,
                navigationIconContentColor = colorScheme.onSurface,
                titleContentColor = colorScheme.onSurface,
                actionIconContentColor = Color.Unspecified
            )
        )
        
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 跟随系统开关
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = stringResource(R.string.language_follow_system),
                                color = colorScheme.onSurface,
                                fontSize = 16.sp,
                                fontFamily = plexSemi
                            )
                            Text(
                                text = stringResource(R.string.language_follow_system_desc),
                                color = colorScheme.onSurfaceVariant,
                                fontSize = 14.sp,
                                fontFamily = plexRegular
                            )
                        }
                        
                        Switch(
                            checked = isFollowSystem,
                            onCheckedChange = { enabled ->
                                isFollowSystem = enabled
                                scope.launch {
                                    themeDataStore.saveFollowSystemLanguage(enabled)
                                    if (enabled) {
                                        applyFollowSystem(context)
                                    } else {
                                        applyLanguageOrder(context, languageOrder)
                                    }
                                    onLanguageChanged?.invoke()
                                }
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = colorScheme.onPrimary,
                                checkedTrackColor = colorScheme.primary,
                                uncheckedThumbColor = colorScheme.outline,
                                uncheckedTrackColor = colorScheme.surfaceContainerHighest
                            )
                        )
                    }
                }
            }
            
            // 语言优先级列表（仅在不跟随系统时显示）
            item {
                AnimatedVisibility(
                    visible = !isFollowSystem,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.language_priority),
                            color = colorScheme.onSurface,
                            fontSize = 14.sp,
                            fontFamily = plexSemi,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
                        )
                        
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Column {
                                sortedLanguages.forEachIndexed { index, item ->
                                    LanguageOrderItem(
                                        item = item,
                                        index = index,
                                        isFirst = index == 0,
                                        isLast = index == sortedLanguages.size - 1,
                                        onMoveUp = {
                                            if (index > 0) {
                                                val newOrder = languageOrder.toMutableList().apply {
                                                    val temp = this[index]
                                                    this[index] = this[index - 1]
                                                    this[index - 1] = temp
                                                }
                                                languageOrder = newOrder
                                                scope.launch {
                                                    themeDataStore.saveLanguageOrder(newOrder)
                                                    applyLanguageOrder(context, newOrder)
                                                    onLanguageChanged?.invoke()
                                                }
                                            }
                                        },
                                        onMoveDown = {
                                            if (index < sortedLanguages.size - 1) {
                                                val newOrder = languageOrder.toMutableList().apply {
                                                    val temp = this[index]
                                                    this[index] = this[index + 1]
                                                    this[index + 1] = temp
                                                }
                                                languageOrder = newOrder
                                                scope.launch {
                                                    themeDataStore.saveLanguageOrder(newOrder)
                                                    applyLanguageOrder(context, newOrder)
                                                    onLanguageChanged?.invoke()
                                                }
                                            }
                                        }
                                    )
                                    
                                    // 分割线
                                    if (index < sortedLanguages.size - 1) {
                                        Spacer(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(0.5.dp)
                                                .background(colorScheme.outlineVariant.copy(alpha = 0.5f))
                                                .padding(horizontal = 56.dp)
                                        )
                                    }
                                }
                            }
                        }
                        
                        // 提示文字
                        Text(
                            text = stringResource(R.string.language_drag_hint),
                            color = colorScheme.onSurfaceVariant,
                            fontSize = 12.sp,
                            fontFamily = plexRegular,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
                        )
                    }
                }
            }
            
            // 提示文字
            item {
                Text(
                    text = stringResource(R.string.language_restart_hint),
                    color = colorScheme.onSurfaceVariant,
                    fontSize = 12.sp,
                    fontFamily = plexRegular,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun LanguageOrderItem(
    item: LanguageItem,
    index: Int,
    isFirst: Boolean,
    isLast: Boolean,
    onMoveUp: () -> Unit,
    onMoveDown: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 序号
        Text(
            text = "${index + 1}",
            color = colorScheme.primary,
            fontSize = 18.sp,
            fontFamily = plexBold,
            modifier = Modifier.width(28.dp)
        )
        
        Spacer(modifier = Modifier.width(12.dp))
        
        // 语言名称
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(item.displayNameResId),
                color = colorScheme.onSurface,
                fontSize = 16.sp,
                fontFamily = plexSemi
            )
            Text(
                text = item.nativeName,
                color = colorScheme.onSurfaceVariant,
                fontSize = 14.sp,
                fontFamily = plexRegular
            )
        }
        
        // 上下移动按钮
        IconButton(
            onClick = onMoveUp,
            enabled = !isFirst
        ) {
            Icon(
                imageVector = Fa.`Chevron-up`,
                contentDescription = stringResource(R.string.language_move_up),
                tint = if (isFirst) colorScheme.outlineVariant else colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )
        }
        
        IconButton(
            onClick = onMoveDown,
            enabled = !isLast
        ) {
            Icon(
                imageVector = Fa.`Chevron-down`,
                contentDescription = stringResource(R.string.language_move_down),
                tint = if (isLast) colorScheme.outlineVariant else colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

/**
 * 应用跟随系统语言
 */
private fun applyFollowSystem(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val localeManager = context.getSystemService(LocaleManager::class.java)
        localeManager?.applicationLocales = LocaleList.getEmptyLocaleList()
    } else {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.getEmptyLocaleList())
    }
}

/**
 * 应用语言优先级顺序
 */
private fun applyLanguageOrder(context: Context, languageOrder: List<String>) {
    val languageTags = languageOrder.joinToString(",")
    
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val localeManager = context.getSystemService(LocaleManager::class.java)
        localeManager?.applicationLocales = LocaleList.forLanguageTags(languageTags)
    } else {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageTags))
    }
}
