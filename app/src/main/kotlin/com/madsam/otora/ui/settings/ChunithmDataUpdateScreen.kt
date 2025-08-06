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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaFont
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ShareUtil
import com.madsam.otora.core.utils.UserAgentUtils
import com.madsam.otora.data.chunithm.remote.api.ChunithmRequestService
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChunithmDataUpdateScreen(
    onNavigateBack: () -> Unit,
    onNavigateToUserAgent: (() -> Unit)? = null,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val context = LocalContext.current
    val requestState = remember { mutableStateOf("") }
    val responseState = remember { mutableStateOf("") }
    val uaState = remember { mutableStateOf("") }
    val requestError = remember { mutableStateOf(false) }
    val responseError = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
    ) {
        // 顶栏
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "CHUNITHM 数据更新",
                    fontFamily = sarasaFont,
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
                modifier = Modifier.padding(20.dp)
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
                                fontFamily = sarasaFont
                            )
                            Text(
                                text = "建议设置User-Agent以确保CHUNITHM数据更新正常工作",
                                color = White1000.copy(alpha = 0.8f),
                                fontSize = 12.sp,
                                fontFamily = sarasaFont
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
                                        fontFamily = sarasaFont,
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                }
                
                // 歌曲数据更新部分
                Text(
                    text = "歌曲数据更新",
                    color = White1000,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = sarasaFont
                )
                
                Text(
                    text = "更新CHUNITHM歌曲数据库",
                    color = White1000.copy(alpha = 0.7f),
                    fontSize = 14.sp,
                    fontFamily = sarasaFont
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 更新歌曲数据按钮
                Button(
                    onClick = {
                        val chunithmRequestService = ChunithmRequestService(context)
                        chunithmRequestService.getChuniSongsData()
                        scope.launch {
                            snackbarHostState.showSnackbar("开始更新歌曲数据")
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = White1000,
                        contentColor = Red500
                    )
                ) {
                    Text(
                        "更新歌曲数据",
                        fontFamily = sarasaFont,
                        fontWeight = FontWeight.Medium
                    )
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // Cookie 配置部分
                Text(
                    text = "Cookie 配置",
                    color = White1000,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = sarasaFont
                )
                
                Text(
                    text = "请输入从CHUNITHM官方网站获取的Cookie信息",
                    color = White1000.copy(alpha = 0.7f),
                    fontSize = 14.sp,
                    fontFamily = sarasaFont
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Request Cookies
                TextField(
                    value = requestState.value,
                    onValueChange = {
                        requestState.value = it
                        requestError.value = it.isEmpty()
                    },
                    label = { 
                        Text(
                            "Request Cookies",
                            fontFamily = sarasaFont,
                            color = White1000.copy(alpha = 0.7f)
                        )
                    },
                    isError = requestError.value,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = White1000,
                        unfocusedTextColor = White1000,
                        focusedContainerColor = Red300,
                        unfocusedContainerColor = Red300,
                        focusedIndicatorColor = Beige400,
                        unfocusedIndicatorColor = White1000.copy(alpha = 0.5f),
                        errorIndicatorColor = MaterialTheme.colorScheme.error
                    )
                )
                if (requestError.value) {
                    Text(
                        "Request Cookies 不能为空",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp,
                        fontFamily = sarasaFont
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Response Cookies
                TextField(
                    value = responseState.value,
                    onValueChange = {
                        responseState.value = it
                        responseError.value = it.isEmpty()
                    },
                    label = { 
                        Text(
                            "Response Cookies",
                            fontFamily = sarasaFont,
                            color = White1000.copy(alpha = 0.7f)
                        )
                    },
                    isError = responseError.value,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = White1000,
                        unfocusedTextColor = White1000,
                        focusedContainerColor = Red300,
                        unfocusedContainerColor = Red300,
                        focusedIndicatorColor = Beige400,
                        unfocusedIndicatorColor = White1000.copy(alpha = 0.5f),
                        errorIndicatorColor = MaterialTheme.colorScheme.error
                    )
                )
                if (responseError.value) {
                    Text(
                        "Response Cookies 不能为空",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp,
                        fontFamily = sarasaFont
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // User-Agent (可选)
                TextField(
                    value = uaState.value,
                    onValueChange = { uaState.value = it },
                    label = { 
                        Text(
                            "User-Agent (可选)",
                            fontFamily = sarasaFont,
                            color = White1000.copy(alpha = 0.7f)
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = White1000,
                        unfocusedTextColor = White1000,
                        focusedContainerColor = Red300,
                        unfocusedContainerColor = Red300,
                        focusedIndicatorColor = Beige400,
                        unfocusedIndicatorColor = White1000.copy(alpha = 0.5f)
                    )
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // 保存Cookies按钮
                Button(
                    onClick = {
                        requestError.value = requestState.value.isEmpty()
                        responseError.value = responseState.value.isEmpty()
                        if (requestError.value || responseError.value) {
                            return@Button
                        }
                        
                        val requestCookieMap = CommonUtils.parseCookie(requestState.value)
                        val responseCookieMap = CommonUtils.parseCookie(responseState.value)
                        
                        if (requestCookieMap.isEmpty() || responseCookieMap.isEmpty()) {
                            scope.launch {
                                snackbarHostState.showSnackbar("Cookie格式无效")
                            }
                            return@Button
                        }
                        
                        // 保存Cookie信息
                        ShareUtil.putString("chuniToken", responseCookieMap["_t"] ?: "", context)
                        ShareUtil.putString("chuniUserId", requestCookieMap["userId"] ?: "", context)
                        ShareUtil.putString("chuniFriendCodeList", requestCookieMap["friendCodeList"] ?: "", context)
                        ShareUtil.putString("chuniExpires", responseCookieMap["expires"] ?: "", context)
                        ShareUtil.putString("chuniMaxAge", responseCookieMap["Max-Age"] ?: "", context)
                        ShareUtil.putString("chuniPath", responseCookieMap["path"] ?: "", context)
                        ShareUtil.putString("chuniSameSite", responseCookieMap["SameSite"] ?: "", context)
                        ShareUtil.putString("chuniGa", requestCookieMap["_ga"] ?: "", context)
                        
                        val gaCount = requestCookieMap.count { it.key.startsWith("_ga_") }
                        if (gaCount == 1) {
                            val entry = requestCookieMap.entries.first { it.key.startsWith("_ga_") }
                            ShareUtil.putString("chuniGaKey", entry.key, context)
                            ShareUtil.putString("chuniGaValue", entry.value, context)
                        }
                        
                        scope.launch {
                            snackbarHostState.showSnackbar("Cookie保存成功")
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Beige400,
                        contentColor = Red500
                    )
                ) {
                    Text(
                        "保存 Cookies",
                        fontFamily = sarasaFont,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
