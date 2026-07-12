package com.madsam.otora.ui.record.osu.dialogs

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.madsam.otora.R
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.utils.DateTimeUtils
import com.madsam.otora.data.osu.ui.model.OsuBadgeUiModel

@Composable
internal fun BadgeDetailSheet(
    badge: OsuBadgeUiModel,
    onDismiss: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    val awardedAt = remember(badge.awardedAt) {
        runCatching { DateTimeUtils.dateCodeToYMDHMSU(badge.awardedAt) }
            .getOrDefault(badge.awardedAt)
    }

    OsuExpandableBottomSheet(
        title = stringResource(R.string.osu_badge_details),
        onDismiss = onDismiss
    ) { _ ->
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(104.dp)
                        .aspectRatio(68f / 32f)
                        .clip(RoundedCornerShape(12.dp))
                        .background(colorScheme.surfaceContainerHighest),
                    contentAlignment = Alignment.Center
                ) {
                    SubcomposeAsyncImage(
                        model = badge.image2xUrl,
                        contentDescription = stringResource(R.string.osu_cd_badge),
                        contentScale = ContentScale.Fit,
                        loading = {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    color = colorScheme.primary,
                                    strokeWidth = 2.dp,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        },
                        error = {
                            Icon(
                                painter = rememberVectorPainter(image = Filled.Picture),
                                contentDescription = null,
                                tint = colorScheme.onSurfaceVariant.copy(alpha = 0.48f),
                                modifier = Modifier.size(28.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                }

                Text(
                    text = badge.description,
                    style = MaterialTheme.typography.titleLarge,
                    color = colorScheme.onSurface,
                    lineHeight = 30.sp,
                    modifier = Modifier.weight(1f)
                )
            }

            if (awardedAt.isNotBlank()) {
                Spacer(modifier = Modifier.size(20.dp))
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    color = colorScheme.surfaceContainer
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Calendar),
                            contentDescription = null,
                            tint = colorScheme.primary,
                            modifier = Modifier.size(22.dp)
                        )
                        Column {
                            Text(
                                text = stringResource(R.string.osu_badge_awarded),
                                style = MaterialTheme.typography.labelLarge.copy(
                                    lineHeight = 22.sp,
                                    platformStyle = PlatformTextStyle(includeFontPadding = true)
                                ),
                                color = colorScheme.onSurfaceVariant,
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = awardedAt,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    lineHeight = 24.sp,
                                    platformStyle = PlatformTextStyle(includeFontPadding = true)
                                ),
                                color = colorScheme.onSurface,
                            )
                        }
                    }
                }
            }

            if (badge.url.isNotBlank()) {
                Spacer(modifier = Modifier.size(20.dp))
                FilledTonalButton(
                    onClick = {
                        val url = badge.url.toAbsoluteOsuUrl()
                        try {
                            uriHandler.openUri(url)
                        } catch (_: Exception) {
                            Toast.makeText(
                                context,
                                context.getString(R.string.osu_link_open_failed, url),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.Link),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(R.string.osu_badge_view_official),
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}

private fun String.toAbsoluteOsuUrl(): String =
    if (startsWith("http://") || startsWith("https://")) {
        this
    } else {
        "https://osu.ppy.sh/${trimStart('/')}"
    }
