package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.madsam.otora.R
import com.madsam.otora.core.theme.plexFamily
import com.madsam.otora.data.osu.ui.model.OsuCardUiModel
import com.madsam.otora.data.osu.ui.model.OsuTopRankUiModel
import com.madsam.otora.ui.components.DoubleCircleIndicator
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.CartesianDrawingContext
import com.patrykandpatrick.vico.compose.cartesian.Zoom
import com.patrykandpatrick.vico.compose.cartesian.axis.HorizontalAxis.Companion.rememberTop
import com.patrykandpatrick.vico.compose.cartesian.axis.VerticalAxis.Companion.rememberStart
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberAxisGuidelineComponent
import com.patrykandpatrick.vico.compose.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.compose.cartesian.data.CartesianLayerRangeProvider
import com.patrykandpatrick.vico.compose.cartesian.data.lineSeries
import com.patrykandpatrick.vico.compose.cartesian.layer.LineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLine
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.marker.CartesianMarker
import com.patrykandpatrick.vico.compose.cartesian.marker.DefaultCartesianMarker
import com.patrykandpatrick.vico.compose.cartesian.marker.DefaultCartesianMarker.ValueFormatter
import com.patrykandpatrick.vico.compose.cartesian.marker.LineCartesianLayerMarkerTarget
import com.patrykandpatrick.vico.compose.cartesian.marker.rememberDefaultCartesianMarker
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoScrollState
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoZoomState
import com.patrykandpatrick.vico.compose.common.Fill
import com.patrykandpatrick.vico.compose.common.Insets
import com.patrykandpatrick.vico.compose.common.component.TextComponent
import com.patrykandpatrick.vico.compose.common.component.rememberTextComponent
import com.patrykandpatrick.vico.compose.common.data.ExtraStore
import kotlinx.coroutines.flow.MutableStateFlow
import java.text.DecimalFormat

/**
 * Material 3 重构版本 - 全球排名趋势卡片
 * 整合了排名数据和历史趋势图表
 */
@Composable
internal fun RankGraph(
    osuRankGraphData: MutableStateFlow<List<Int>>,
    osuRankHighestData: MutableStateFlow<OsuTopRankUiModel>,
    osuCardData: MutableStateFlow<OsuCardUiModel>,
    cardWidthDp: Dp
) {
    val colorScheme = MaterialTheme.colorScheme
    val rankGraphData by osuRankGraphData.collectAsState()
    val highestData by osuRankHighestData.collectAsState()
    val cardData by osuCardData.collectAsState()

    Card(
        modifier = Modifier
            .width(cardWidthDp)
            .padding(bottom = 12.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surfaceContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // 排名数据区域
            RankDataSection(
                cardData = cardData,
                highestData = highestData,
                colorScheme = colorScheme
            )

            // 图表区域
            Box(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                if (rankGraphData.isEmpty()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(32.dp),
                            color = colorScheme.primary,
                            strokeWidth = 3.dp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Loading data...",
                            color = colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodyMedium
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

                    val indicatorComponent = DoubleCircleIndicator(
                        outerCircleColor = colorScheme.primary.copy(alpha = 0.3f),
                        innerCircleColor = colorScheme.primary
                    )

                    CartesianChartHost(
                        modifier = Modifier
                            .padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 0.dp
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
                                        fill = LineCartesianLayer.LineFill.single(Fill(colorScheme.primary)),
                                        areaFill = LineCartesianLayer.AreaFill.single(
                                            Fill(
                                                Brush.verticalGradient(
                                                    colors = listOf(
                                                        Color.Transparent,
                                                        colorScheme.primary.copy(alpha = 0.3f)
                                                    )
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
                                        (osuRankGraphData.value.maxOrNull()?.toFloat()
                                            ?: -100f) * 1.03

                                    override fun getMaxY(
                                        minY: Double,
                                        maxY: Double,
                                        extraStore: ExtraStore
                                    ) =
                                        (osuRankGraphData.value.minOrNull()?.toFloat() ?: 0f) * 0.97
                                },
                            ),
                            startAxis = rememberStart(
                                guideline = null,
                                tick = null,
                                line = null,
                                label = null,
                            ),
                            topAxis = rememberTop(
                                guideline = null,
                                tick = null,
                                line = null,
                                label = null,
                            ),
                            marker = rememberDefaultCartesianMarker(
                                label = rememberTextComponent(
                                    style = TextStyle(
                                        fontSize = 13.sp,
                                        color = colorScheme.primary,
                                        textAlign = TextAlign.Center
                                    ),
                                    padding = Insets(4.dp, 2.dp),
                                    minWidth = TextComponent.MinWidth.fixed(40.dp),
                                ),
                                labelPosition = DefaultCartesianMarker.LabelPosition.Top,
                                guideline = rememberAxisGuidelineComponent(
                                    fill = Fill(colorScheme.primary.copy(alpha = 0.3f))
                                ),
                                indicator = remember(indicatorComponent) {
                                    { _: Color -> indicatorComponent }
                                },
                                valueFormatter = object : ValueFormatter {
                                    private val decimalFormatX = DecimalFormat("0")
                                    private val decimalFormatY = DecimalFormat("'#'#,###")

                                    override fun format(
                                        context: CartesianDrawingContext,
                                        targets: List<CartesianMarker.Target>
                                    ): CharSequence {
                                        return targets.joinToString { target ->
                                            val xValue = 90 - target.x
                                            val yValue =
                                                if (target is LineCartesianLayerMarkerTarget) {
                                                    target.points.sumOf { it.entry.y }
                                                } else {
                                                    throw IllegalArgumentException("Unexpected `CartesianMarker.Target` implementation.")
                                                }
                                            "${decimalFormatY.format(yValue)} - ${
                                                decimalFormatX.format(xValue)
                                            } days ago"
                                        }
                                    }
                                }
                            ),
                        ),
                        modelProducer = modelProducer,
                    )
                }
            }
        }
    }
}

@Composable
private fun RankDataSection(
    cardData: OsuCardUiModel,
    highestData: OsuTopRankUiModel,
    colorScheme: ColorScheme
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top=16.dp, bottom = 6.dp)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // --- Global Column ---
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Highest Rank (MAX) - Top
            if (highestData.rank.isNotEmpty()) {
                Surface(
                    color = colorScheme.primaryContainer,
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier.padding(bottom = 4.dp)
                ) {
                    Text(
                        text = "MAX #${highestData.rank}",
                        style = MaterialTheme.typography.labelSmall,
                        color = colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            } else {
                Spacer(modifier = Modifier.height(24.dp))
            }

            // Main Rank
            Text(
                text = cardData.rank,
                style = TextStyle(
                    color = colorScheme.primary,
                    fontFamily = plexFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            // Label
            Text(
                text = stringResource(id = R.string.global_ranking),
                style = MaterialTheme.typography.bodySmall,
                color = colorScheme.onSurfaceVariant
            )

            // Variants (Global)
            if (cardData.mania4kGlobalRank.isNotEmpty() || cardData.mania7kGlobalRank.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                if (cardData.mania4kGlobalRank.isNotEmpty()) {
                    Text(
                        text = "4K: ${cardData.mania4kGlobalRank}",
                        style = MaterialTheme.typography.labelSmall,
                        color = colorScheme.secondary
                    )
                }
                if (cardData.mania7kGlobalRank.isNotEmpty()) {
                    Text(
                        text = "7K: ${cardData.mania7kGlobalRank}",
                        style = MaterialTheme.typography.labelSmall,
                        color = colorScheme.secondary
                    )
                }
            }
        }

        // --- Country Column ---
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Spacer to align with Global column's MAX badge
            Spacer(modifier = Modifier.height(24.dp))

            // Main Rank
            Text(
                text = cardData.countryRank,
                style = TextStyle(
                    color = colorScheme.secondary,
                    fontFamily = plexFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            // Label (Flag + Name)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(cardData.flagUrl)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .height(12.dp)
                        .width(18.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = cardData.country,
                    style = MaterialTheme.typography.bodySmall,
                    color = colorScheme.onSurfaceVariant
                )
            }

            // Variants (Country)
            if (cardData.mania4kCountryRank.isNotEmpty() || cardData.mania7kCountryRank.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                if (cardData.mania4kCountryRank.isNotEmpty()) {
                    Text(
                        text = "4K: ${cardData.mania4kCountryRank}",
                        style = MaterialTheme.typography.labelSmall,
                        color = colorScheme.secondary
                    )
                }
                if (cardData.mania7kCountryRank.isNotEmpty()) {
                    Text(
                        text = "7K: ${cardData.mania7kCountryRank}",
                        style = MaterialTheme.typography.labelSmall,
                        color = colorScheme.secondary
                    )
                }
            }
        }
    }
}