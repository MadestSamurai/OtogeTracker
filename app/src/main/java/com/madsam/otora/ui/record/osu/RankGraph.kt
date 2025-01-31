package com.madsam.otora.ui.record.osu

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.R
import com.madsam.otora.components.DoubleCircleIndicator
import com.madsam.otora.consts.DARK_RED_DEEP
import com.madsam.otora.consts.DARK_RED_TEXT_LIGHT
import com.madsam.otora.consts.OSU_BRIGHT_YELLOW
import com.madsam.otora.consts.OSU_BRIGHT_YELLOW_HALF_TRANS
import com.madsam.otora.consts.TEXT_GRAY
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberAxisGuidelineComponent
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStart
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberTop
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLine
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.marker.rememberDefaultCartesianMarker
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoScrollState
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoZoomState
import com.patrykandpatrick.vico.compose.common.component.fixed
import com.patrykandpatrick.vico.compose.common.component.rememberTextComponent
import com.patrykandpatrick.vico.compose.common.fill
import com.patrykandpatrick.vico.core.cartesian.CartesianDrawingContext
import com.patrykandpatrick.vico.core.cartesian.Zoom
import com.patrykandpatrick.vico.core.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.CartesianLayerRangeProvider
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries
import com.patrykandpatrick.vico.core.cartesian.layer.LineCartesianLayer
import com.patrykandpatrick.vico.core.cartesian.marker.CartesianMarker
import com.patrykandpatrick.vico.core.cartesian.marker.DefaultCartesianMarker
import com.patrykandpatrick.vico.core.cartesian.marker.DefaultCartesianMarker.ValueFormatter
import com.patrykandpatrick.vico.core.cartesian.marker.LineCartesianLayerMarkerTarget
import com.patrykandpatrick.vico.core.common.Insets
import com.patrykandpatrick.vico.core.common.component.TextComponent
import com.patrykandpatrick.vico.core.common.data.ExtraStore
import com.patrykandpatrick.vico.core.common.shader.ShaderProvider
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.flow.MutableStateFlow
import java.text.DecimalFormat

@Composable
fun RankGraph(
    osuRankGraphData: MutableStateFlow<List<Int>>,
    osuRankHighestData: MutableStateFlow<Map<String, String>>
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp

    val rankGraphData by osuRankGraphData.collectAsState()
    val highestData by osuRankHighestData.collectAsState()

    val cardWidthDp = screenWidthDp - 32.dp
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
            .width(cardWidthDp)
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp, topEnd = 20.dp,
                    bottomStart = 6.dp, bottomEnd = 6.dp
                )
            )
            .background(DARK_RED_DEEP),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.global_ranking),
            color = DARK_RED_TEXT_LIGHT,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 10.dp)
        )

        Text(
            text = stringResource(id = R.string.recent_90_days),
            color = DARK_RED_TEXT_LIGHT,
            fontSize = 16.sp
        )

        if (rankGraphData.isEmpty()) {
            Box(
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        end = 15.dp
                    )
                    .height(100.dp)
            ) {
                Text(
                    text = "Loading data...",
                    color = DARK_RED_TEXT_LIGHT,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box(
                modifier = Modifier
                    .shimmer()
                    .padding(bottom = 10.dp)
                    .width(150.dp)
                    .height(24.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(TEXT_GRAY)
            )
        } else {
            val modelProducer = remember { CartesianChartModelProducer() }
            LaunchedEffect(rankGraphData) {
                modelProducer.runTransaction {
                    lineSeries {
                        series(osuRankGraphData.value.map { it })
                    }
                }
            }

            val indicatorComponent = DoubleCircleIndicator(
                outerCircleColor = OSU_BRIGHT_YELLOW_HALF_TRANS,
                innerCircleColor = OSU_BRIGHT_YELLOW
            )

            CartesianChartHost(
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        end = 15.dp,
                        top = 4.dp
                    )
                    .height(100.dp)
                    .pointerInput(Unit) {
                        detectDragGestures { change, _ ->
                            change.consume()
                        }
                    },
                zoomState = rememberVicoZoomState(
                    zoomEnabled = false,
                    initialZoom = Zoom.x(90.0)
                ),
                scrollState = rememberVicoScrollState(
                    scrollEnabled = false
                ),
                chart = rememberCartesianChart(
                    rememberLineCartesianLayer(
                        lineProvider = LineCartesianLayer.LineProvider.series(
                            LineCartesianLayer.rememberLine(
                                fill = LineCartesianLayer.LineFill.single(fill(OSU_BRIGHT_YELLOW)),
                                areaFill = LineCartesianLayer.AreaFill.single(
                                    fill(
                                        ShaderProvider.verticalGradient(
                                            Color.Transparent.toArgb(),
                                            OSU_BRIGHT_YELLOW_HALF_TRANS.toArgb()
                                        )
                                    )
                                ),
                            )
                        ),
                        rangeProvider = object : CartesianLayerRangeProvider {
                            override fun getMinY(
                                minY: Double,
                                maxY: Double,
                                extraStore: ExtraStore
                            ) =
                                (osuRankGraphData.value.maxOrNull()?.toFloat() ?: -100f) * 1.03

                            override fun getMaxY(
                                minY: Double,
                                maxY: Double,
                                extraStore: ExtraStore
                            ) =
                                (osuRankGraphData.value.minOrNull()?.toFloat() ?: 0f) * 0.97
                        },
                    ),
                    startAxis = VerticalAxis.rememberStart(
                        guideline = null,
                        tick = null,
                        line = null,
                        label = null,
                    ),
                    topAxis = HorizontalAxis.rememberTop(
                        guideline = null,
                        tick = null,
                        line = null,
                        label = null,
                    ),
                    marker = rememberDefaultCartesianMarker(
                        label = rememberTextComponent(
                            padding = Insets(4f, 2f),
                            textAlignment = Layout.Alignment.ALIGN_CENTER,
                            minWidth = TextComponent.MinWidth.fixed(40.dp),
                            textSize = 13.sp,
                            color = OSU_BRIGHT_YELLOW
                        ),
                        labelPosition = DefaultCartesianMarker.LabelPosition.Top,
                        guideline = rememberAxisGuidelineComponent(
                            fill = fill(OSU_BRIGHT_YELLOW_HALF_TRANS)
                        ),
                        indicator = remember { { indicatorComponent } },
                        valueFormatter = object : ValueFormatter {
                            private val decimalFormatX = DecimalFormat("0")
                            private val decimalFormatY = DecimalFormat("'#'#,###")

                            override fun format(
                                context: CartesianDrawingContext,
                                targets: List<CartesianMarker.Target>
                            ): CharSequence {
                                return targets.joinToString { target ->
                                    val xValue = 90 - target.x
                                    val yValue = if (target is LineCartesianLayerMarkerTarget) {
                                        target.points.sumOf { it.entry.y }
                                    } else {
                                        throw IllegalArgumentException("Unexpected `CartesianMarker.Target` implementation.")
                                    }
                                    "${decimalFormatY.format(yValue)} - ${
                                        decimalFormatX.format(
                                            xValue
                                        )
                                    } days ago"
                                }
                            }
                        }
                    ),
                ),
                modelProducer = modelProducer,
            )
        }

        if ((highestData["rank"] == null || highestData["rank"] == "0" || highestData["rank"] == "") && (highestData["date"] == null || highestData["date"] == "")) {
            return@Column
        }
        Text(
            text = buildAnnotatedString {
                append("")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                ) {
                    if (highestData["rank"] != null) {
                        append("${stringResource(id = R.string.highest_rank)}: #${highestData["rank"]}")
                    }
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                ) {
                    if (highestData["date"] != null) {
                        append(" (${highestData["date"]!!.split("T")[0]})")
                    }
                }
            },
            color = DARK_RED_TEXT_LIGHT,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}