package com.madsam.otora.ui.record.osu.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.OSU_BRIGHT_RED
import com.madsam.otora.core.theme.OSU_DISCORD_BG
import com.madsam.otora.core.theme.OSU_DISCORD_TEXT
import com.madsam.otora.core.theme.OSU_X_BG
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.utils.DateTimeUtils.dateCodeToRecent
import com.madsam.otora.core.utils.DateTimeUtils.dateCodeToYMDHMSU
import com.madsam.otora.data.osu.ui.model.OsuSocialUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun SocialCard(
    osuSocialCard: MutableStateFlow<OsuSocialUiModel>,
    cardWidthDp: Dp
) {
    val colorScheme = MaterialTheme.colorScheme
    val data by osuSocialCard.collectAsState()

    Column(
        modifier = Modifier
            .width(cardWidthDp)
            .padding(bottom = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(colorScheme.surfaceContainer)
            .padding(vertical = 16.dp)
    ) {
        // User Info Section
        UserInfoSection(data = data)
        
        // Social Links Section  
        SocialLinksSection(data = data)
    }
}

@Composable
private fun UserInfoSection(data: OsuSocialUiModel) {
    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
    ) {
        InfoText(
            prefix = "Joined ",
            text = dateCodeToYMDHMSU(data.joinDate)
        )
        
        InfoText(
            prefix = "Last seen ",
            text = dateCodeToRecent(data.lastVisit)
        )
        
        if (data.location.isNotEmpty()) {
            InfoText(
                prefix = "From ",
                text = data.location
            )
        }
        
        if (data.playStyle.isNotEmpty()) {
            InfoText(
                prefix = "Plays with ",
                text = data.playStyle,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
private fun InfoText(
    prefix: String,
    text: String,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme
    Text(
        text = buildAnnotatedString {
            append(prefix)
            withStyle(style = MaterialTheme.typography.titleMedium.toSpanStyle()) {
                append(text)
            }
        },
        style = MaterialTheme.typography.bodyLarge,
        color = colorScheme.onSurface,
        modifier = modifier
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SocialLinksSection(data: OsuSocialUiModel) {
    val uriHandler = LocalUriHandler.current
    val context = LocalContext.current
    
    val socialLinks = buildList {
        if (data.twitter.isNotEmpty()) {
            add(
                SocialLinkData(
                    icon = Filled.XLogo,
                    text = "@${data.twitter}",
                    backgroundColor = OSU_X_BG,
                    contentColor = White1000,
                    url = "https://x.com/${data.twitter}"
                )
            )
        }
        
        if (data.discord.isNotEmpty()) {
            add(
                SocialLinkData(
                    icon = Filled.Discord,
                    text = data.discord,
                    backgroundColor = OSU_DISCORD_BG,
                    contentColor = OSU_DISCORD_TEXT,
                    url = null // Discord 用户名通常不能直接跳转
                )
            )
        }
        
        if (data.website.isNotEmpty()) {
            add(
                SocialLinkData(
                    icon = Filled.Link,
                    text = data.website,
                    backgroundColor = OSU_BRIGHT_RED,
                    contentColor = Color.White,
                    url = if (data.website.startsWith("http")) data.website else "https://${data.website}"
                )
            )
        }
    }
    
    if (socialLinks.isNotEmpty()) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            socialLinks.forEach { linkData ->
                SocialLinkChip(
                    linkData = linkData,
                    onClick = { url ->
                        try {
                            uriHandler.openUri(url)
                        } catch (_: Exception) {
                            // 显示错误提示
                            Toast.makeText(
                                context,
                                "无法打开链接: $url",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                )
            }
        }
    }
}

private data class SocialLinkData(
    val icon: ImageVector,
    val text: String,
    val backgroundColor: Color,
    val contentColor: Color,
    val url: String? = null
)

@Composable
private fun SocialLinkChip(
    linkData: SocialLinkData,
    onClick: (String) -> Unit
) {
    Surface(
        color = linkData.backgroundColor,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .then(
                if (linkData.url != null) {
                    Modifier.clickable { onClick(linkData.url) }
                } else {
                    Modifier
                }
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Image(
                painter = rememberVectorPainter(image = linkData.icon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(linkData.contentColor),
                modifier = Modifier.height(16.dp)
            )
            
            Text(
                text = linkData.text,
                style = MaterialTheme.typography.bodyMedium,
                color = linkData.contentColor,
                modifier = Modifier.padding(start = 6.dp)
            )
        }
    }
}
