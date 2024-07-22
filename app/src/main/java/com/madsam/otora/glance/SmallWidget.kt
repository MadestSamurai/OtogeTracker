package com.madsam.otora.glance

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.LocalContext
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.madsam.otora.utils.ShareUtil

class SmallWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                MyContent()
            }
        }
    }
    @Composable
    private fun MyContent() {
        val context = LocalContext.current
        val text = ShareUtil.getString("osuUserPp", context)?:"NaN"
        println(text)
        Column(
            modifier = GlanceModifier.fillMaxSize()
                .background(GlanceTheme.colors.background),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text + "pp",
                modifier = GlanceModifier
                    .padding(12.dp),
                style = TextStyle(
                    color = GlanceTheme.colors.onBackground,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
