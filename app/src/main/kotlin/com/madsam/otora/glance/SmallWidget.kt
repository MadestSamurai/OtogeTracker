package com.madsam.otora.glance

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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
import com.madsam.otora.glance.data.GlanceWidgetDataStore
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

// Glance Widget 专用颜色（不支持 MaterialTheme.colorScheme）
// 基于 M3E Neutral Tonal Palette (Chroma: 16) - 明显紫罗兰色调
private val GlanceWidgetBackground = Color(0xFF2B2733)  // Neutral17 - 紫灰
private val GlanceWidgetText = Color(0xFFE7E1EC)        // Neutral90 - 浅紫灰

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
        val osuGlanceJson = GlanceWidgetDataStore.getOsuWidgetData(context) ?: "{}"
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val osuGlanceAdapter = moshi.adapter(Map::class.java)
        val osuGlance = osuGlanceAdapter.fromJson(osuGlanceJson) as Map<*, *>
        println(osuGlance)
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceWidgetBackground),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = osuGlance["username"].toString(),
                modifier = GlanceModifier
                    .padding(12.dp),
                style = TextStyle(
                    color = MyColorProvider(GlanceWidgetText),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = osuGlance["pp"].toString() + "pp",
                modifier = GlanceModifier
                    .padding(12.dp),
                style = TextStyle(
                    color = MyColorProvider(GlanceWidgetText),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

data class MyColorProvider(val color: Color) : ColorProvider {
    override fun getColor(context: Context): Color {
        return color
    }
}
