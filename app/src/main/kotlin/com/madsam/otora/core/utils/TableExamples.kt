package com.madsam.otora.core.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * 实际应用示例：更直接的表格实现
 * 展示如何替代复杂的响应式计算
 */

data class TableItem(
    val name: String,
    val score: String,
    val rank: String
)

@Composable
fun SimpleTable(
    items: List<TableItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            SimpleTableRow(item = item)
        }
    }
}

@Composable
fun SimpleTableRow(item: TableItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            // 方法1: 使用固定的舒适行高
            .height(48.dp)
            // 或者方法2: 使用最小高度 + 自适应
            // .heightIn(min = 44.dp)
            // 或者方法3: 完全自适应
            // .wrapContentHeight()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 名称列
        Text(
            text = item.name,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium,
            // 文本自动垂直居中，无需额外计算
        )
        
        // 分数列
        Text(
            text = item.score,
            modifier = Modifier.width(80.dp),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End
        )
        
        // 排名列
        Text(
            text = item.rank,
            modifier = Modifier.width(60.dp),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * 更高级的表格实现：带有自定义行高策略
 */
@Composable
fun FlexibleTable(
    items: List<TableItem>,
    rowHeightStrategy: RowHeightStrategy = RowHeightStrategy.Comfortable,
    modifier: Modifier = Modifier
) {
    val rowHeight = when (rowHeightStrategy) {
        RowHeightStrategy.Compact -> 36.dp
        RowHeightStrategy.Comfortable -> 48.dp
        RowHeightStrategy.Spacious -> 64.dp
        RowHeightStrategy.Auto -> null // 使用自适应高度
    }
    
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .let { mod ->
                        if (rowHeight != null) {
                            mod.height(rowHeight)
                        } else {
                            mod.wrapContentHeight(Alignment.CenterVertically)
                        }
                    }
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = item.score,
                    modifier = Modifier.width(80.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End
                )
                Text(
                    text = item.rank,
                    modifier = Modifier.width(60.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

enum class RowHeightStrategy {
    Compact,     // 紧凑模式
    Comfortable, // 舒适模式（默认）
    Spacious,    // 宽松模式
    Auto         // 自适应模式
}

/**
 * 最简单的方法：使用 Material Design 标准
 */
@Composable
fun MaterialTable(
    items: List<TableItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            // 直接使用 Material Design 推荐的 ListItem 高度
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp) // Material Design 标准 ListItem 高度
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyLarge // 使用主题定义的文本样式
                )
                Text(
                    text = item.score,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
