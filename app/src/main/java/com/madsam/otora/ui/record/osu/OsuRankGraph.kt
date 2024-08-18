package com.madsam.otora.ui.record.osu

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.consts.Colors
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberAxisGuidelineComponent
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStartAxis
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberTopAxis
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLine
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.marker.rememberDefaultCartesianMarker
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoScrollState
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoZoomState
import com.patrykandpatrick.vico.compose.common.component.fixed
import com.patrykandpatrick.vico.compose.common.component.rememberShapeComponent
import com.patrykandpatrick.vico.compose.common.component.rememberTextComponent
import com.patrykandpatrick.vico.compose.common.fill
import com.patrykandpatrick.vico.compose.common.of
import com.patrykandpatrick.vico.core.cartesian.CartesianDrawContext
import com.patrykandpatrick.vico.core.cartesian.Zoom
import com.patrykandpatrick.vico.core.cartesian.data.AxisValueOverrider
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries
import com.patrykandpatrick.vico.core.cartesian.layer.LineCartesianLayer
import com.patrykandpatrick.vico.core.cartesian.marker.CartesianMarker
import com.patrykandpatrick.vico.core.cartesian.marker.CartesianMarkerValueFormatter
import com.patrykandpatrick.vico.core.cartesian.marker.DefaultCartesianMarker
import com.patrykandpatrick.vico.core.cartesian.marker.LineCartesianLayerMarkerTarget
import com.patrykandpatrick.vico.core.common.Dimensions
import com.patrykandpatrick.vico.core.common.component.TextComponent
import com.patrykandpatrick.vico.core.common.shape.Shape
import kotlinx.coroutines.flow.MutableStateFlow
import java.text.DecimalFormat

@Composable
fun OsuRankGraph(
    osuRankGraphData: MutableStateFlow<List<Int>>,
    osuRankHighestData: MutableStateFlow<Map<String, String>>
) {
    val rankGraphData by osuRankGraphData.collectAsState()
    val highestData by osuRankHighestData.collectAsState()
    Surface(
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
            bottomStart = 6.dp,
            bottomEnd = 6.dp
        ),
        color = Color.Transparent,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 4.dp
            )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Colors.DARK_RED_DEEP)
        ) {
            val (
                rankGraph,
                title,
                subtitle,
                highestRank
            ) = createRefs()

            Text(
                text = "Global Ranking",
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
            )

            Text(
                text = "Recent 90 Days",
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 16.sp,
                modifier = Modifier
                    .constrainAs(subtitle) {
                        top.linkTo(title.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            if (rankGraphData.isEmpty()) {
                Box(
                    modifier = Modifier
                        .constrainAs(rankGraph) {
                            top.linkTo(subtitle.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(
                            start = 15.dp,
                            end = 15.dp
                        )
                        .height(100.dp)
                ) {
                    Text(
                        text = "Loading data...",
                        color = Colors.DARK_RED_TEXT_LIGHT,
                        fontSize = 16.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else {
                val modelProducer = remember { CartesianChartModelProducer() }
                LaunchedEffect(rankGraphData) {
                    modelProducer.runTransaction {
                        lineSeries {
                            series(osuRankGraphData.value.map { it })
                        }
                    }
                }

                val indicatorComponent = rememberShapeComponent(shape = Shape.Pill, color = Colors.OSU_BRIGHT_YELLOW)

                CartesianChartHost(
                    modifier = Modifier
                        .constrainAs(rankGraph) {
                            top.linkTo(subtitle.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(
                            start = 15.dp,
                            end = 15.dp
                        )
                        .height(100.dp),
                    zoomState = rememberVicoZoomState(
                        zoomEnabled = false,
                        initialZoom = Zoom.x(90.0)
                    ),
                    scrollState = rememberVicoScrollState(
                        scrollEnabled = false,
                    ),
                    chart = rememberCartesianChart(
                        rememberLineCartesianLayer(
                            lineProvider = LineCartesianLayer.LineProvider.series(
                                rememberLine(
                                    remember {
                                        LineCartesianLayer.LineFill.single(fill = fill(Colors.OSU_BRIGHT_YELLOW))
                                    }
                                )
                            ),
                            axisValueOverrider = AxisValueOverrider.fixed(
                                maxY = (osuRankGraphData.value.minOrNull()?.toFloat() ?: 0f) * 0.97,
                                minY = (osuRankGraphData.value.maxOrNull()?.toFloat() ?: -100f) * 1.03,
                            )
                        ),
                        startAxis = rememberStartAxis(
                            guideline = null,
                            tick = null,
                            line = null,
                            label = null,
                        ),
                        topAxis = rememberTopAxis(
                            guideline = null,
                            tick = null,
                            line = null,
                            label = null,
                        ),
                        marker = rememberDefaultCartesianMarker(
                            label = rememberTextComponent(
                                padding = Dimensions.of(8.dp, 4.dp),
                                textAlignment = Layout.Alignment.ALIGN_CENTER,
                                minWidth = TextComponent.MinWidth.fixed(40.dp),
                                textSize = 13.sp,
                                color = Colors.OSU_BRIGHT_YELLOW
                            ),
                            labelPosition = DefaultCartesianMarker.LabelPosition.Top,
                            guideline = rememberAxisGuidelineComponent(
                                color = Colors.OSU_BRIGHT_YELLOW_HALF_TRANS
                            ),
                            indicator = remember {{ indicatorComponent }},
                            valueFormatter = object : CartesianMarkerValueFormatter {
                                private val decimalFormatX = DecimalFormat("0")
                                private val decimalFormatY = DecimalFormat("'#'#,###")

                                override fun format(
                                    context: CartesianDrawContext,
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
                            append("Highest Rank: #${highestData["rank"]}")
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
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 16.sp,
                modifier = Modifier
                    .constrainAs(highestRank) {
                        top.linkTo(rankGraph.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(
                        bottom = 10.dp
                    )
            )
        }
    }
}