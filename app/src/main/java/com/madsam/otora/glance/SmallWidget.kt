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
import androidx.glance.unit.ColorProvider
import com.madsam.otora.consts.Colors
import com.madsam.otora.utils.ShareUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

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
        val osuGlanceJson = ShareUtil.getString("osuGlance", context)?: "{}"
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val osuGlanceAdapter = moshi.adapter(Map::class.java)
        val osuGlance = osuGlanceAdapter.fromJson(osuGlanceJson) as Map<*, *>
        println(osuGlance)
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(color = Colors.DARK_RED_DEEP),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = osuGlance["username"].toString(),
                modifier = GlanceModifier
                    .padding(12.dp),
                style = TextStyle(
                    color = ColorProvider(Colors.DARK_RED_TEXT_LIGHT),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = osuGlance["pp"].toString() + "pp",
                modifier = GlanceModifier
                    .padding(12.dp),
                style = TextStyle(
                    color = ColorProvider(Colors.DARK_RED_TEXT_LIGHT),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
