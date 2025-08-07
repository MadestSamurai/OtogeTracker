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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.interTight
import com.madsam.otora.core.utils.UserAgentUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaimaiDataUpdateScreen(
    onNavigateBack: () -> Unit,
    onNavigateToUserAgent: (() -> Unit)? = null
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
    ) {
        // 顶栏
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "maimai DX 数据更新",
                    fontFamily = interTight,
                    fontWeight = FontWeight.Bold,
                    color = Beige400
                )
            },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "返回",
                        tint = Beige400,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Red500,
                titleContentColor = Beige400,
                navigationIconContentColor = Beige400
            )
        )
        
        // 设置内容
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Red500),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // User-Agent检查提示
                if (!UserAgentUtils.isUserAgentValid(context)) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Red300),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "⚠️ User-Agent未设置",
                                color = White1000,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = interTight
                            )
                            Text(
                                text = "建议设置User-Agent以确保maimai DX数据更新正常工作",
                                color = White1000.copy(alpha = 0.8f),
                                fontSize = 12.sp,
                                fontFamily = interTight
                            )
                            
                            if (onNavigateToUserAgent != null) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Button(
                                    onClick = onNavigateToUserAgent,
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Beige400,
                                        contentColor = Red500
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "设置User-Agent",
                                        fontFamily = interTight,
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                }
                
                Text(
                    text = "maimai DX 数据更新",
                    color = White1000,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = interTight,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "maimai DX 的数据更新功能即将推出。\n敬请期待！",
                    color = White1000.copy(alpha = 0.7f),
                    fontSize = 14.sp,
                    fontFamily = interTight,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // 占位按钮
                Button(
                    onClick = { /* TODO: 实现maimai数据更新 */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Beige400.copy(alpha = 0.5f),
                        contentColor = Red500
                    ),
                    enabled = false
                ) {
                    Text(
                        "即将推出",
                        fontFamily = interTight,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
