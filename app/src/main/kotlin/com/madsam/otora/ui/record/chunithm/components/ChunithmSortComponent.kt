package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular

@Composable
fun ChunithmSortComponent(
    isSortExpanded: Boolean,
    selectedSortOption: MutableState<String>,
    isAscendingOrder: MutableState<Boolean>,
    onSortOptionSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = isSortExpanded,
        enter = expandVertically(),
        exit = shrinkVertically(),
        modifier = modifier
            .fillMaxWidth()
            .zIndex(2f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Red300)
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = "排序选项",
                color = Beige500,
                fontSize = 16.sp,
                fontFamily = sarasaBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            // 正序/倒序切换按钮
            SortOrderRow(
                isAscendingOrder = isAscendingOrder
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // 基本排序选项
            BasicSortOptionsRow(
                selectedSortOption = selectedSortOption,
                onSortOptionSelected = onSortOptionSelected
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // CN Value排序选项
            CnValueSortSection(
                selectedSortOption = selectedSortOption,
                onSortOptionSelected = onSortOptionSelected
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // JP Value排序选项
            JpValueSortSection(
                selectedSortOption = selectedSortOption,
                onSortOptionSelected = onSortOptionSelected
            )
        }
    }
}

@Composable
private fun SortOrderRow(
    isAscendingOrder: MutableState<Boolean>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(28.dp)
                .background(
                    if (isAscendingOrder.value) Red500 else Red300,
                    RoundedCornerShape(10.dp)
                )
                .clickable {
                    isAscendingOrder.value = true
                }
                .padding(horizontal = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "正序 ↑",
                color = Beige500,
                fontSize = 12.sp,
                fontFamily = if (isAscendingOrder.value) sarasaBold else sarasaRegular,
                textAlign = TextAlign.Center
            )
        }
        
        Box(
            modifier = Modifier
                .weight(1f)
                .height(28.dp)
                .background(
                    if (!isAscendingOrder.value) Red500 else Red300,
                    RoundedCornerShape(10.dp)
                )
                .clickable {
                    isAscendingOrder.value = false
                }
                .padding(horizontal = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "倒序 ↓",
                color = Beige500,
                fontSize = 12.sp,
                fontFamily = if (!isAscendingOrder.value) sarasaBold else sarasaRegular,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun BasicSortOptionsRow(
    selectedSortOption: MutableState<String>,
    onSortOptionSelected: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val basicSortOptions = listOf(
            "default" to "默认顺序",
            "title" to "标题",
            "artist" to "艺术家"
        )
        
        basicSortOptions.forEach { (value, label) ->
            val isSelected = selectedSortOption.value == value
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(32.dp)
                    .background(
                        if (isSelected) Red500 else Red300,
                        RoundedCornerShape(12.dp)
                    )
                    .clickable {
                        selectedSortOption.value = value
                        onSortOptionSelected()
                    }
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    color = Beige500,
                    fontSize = 13.sp,
                    fontFamily = if (isSelected) sarasaBold else sarasaRegular,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun CnValueSortSection(
    selectedSortOption: MutableState<String>,
    onSortOptionSelected: () -> Unit
) {
    Text(
        text = "按CN Value排序",
        color = Beige500,
        fontSize = 14.sp,
        fontFamily = sarasaBold,
        modifier = Modifier.padding(bottom = 4.dp)
    )
    
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        val cnSortOptions = listOf(
            "basic_cn" to "BAS",
            "advanced_cn" to "ADV", 
            "expert_cn" to "EXP",
            "master_cn" to "MAS",
            "ultima_cn" to "ULT"
        )
        
        cnSortOptions.forEach { (value, label) ->
            val isSelected = selectedSortOption.value == value
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(28.dp)
                    .background(
                        if (isSelected) Red500 else Red300,
                        RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        selectedSortOption.value = value
                        onSortOptionSelected()
                    }
                    .padding(horizontal = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    color = Beige500,
                    fontSize = 11.sp,
                    fontFamily = if (isSelected) sarasaBold else sarasaRegular,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun JpValueSortSection(
    selectedSortOption: MutableState<String>,
    onSortOptionSelected: () -> Unit
) {
    Text(
        text = "按JP Value排序",
        color = Beige500,
        fontSize = 14.sp,
        fontFamily = sarasaBold,
        modifier = Modifier.padding(bottom = 4.dp)
    )
    
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        val jpSortOptions = listOf(
            "basic_jp" to "BAS",
            "advanced_jp" to "ADV",
            "expert_jp" to "EXP", 
            "master_jp" to "MAS",
            "ultima_jp" to "ULT"
        )
        
        jpSortOptions.forEach { (value, label) ->
            val isSelected = selectedSortOption.value == value
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(28.dp)
                    .background(
                        if (isSelected) Red500 else Red300,
                        RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        selectedSortOption.value = value
                        onSortOptionSelected()
                    }
                    .padding(horizontal = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    color = Beige500,
                    fontSize = 11.sp,
                    fontFamily = if (isSelected) sarasaBold else sarasaRegular,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
