package com.madsam.otora.ui.record.osu.components

import android.text.Layout
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.madsam.otora.R
import com.madsam.otora.core.theme.TEXT_GRAY // TODO: 硬编码颜色 - 考虑改为outlineVariant
import com.madsam.otora.core.theme.sarasaFamily
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.data.osu.ui.model.OsuCardUiModel
import com.madsam.otora.data.osu.ui.model.OsuTopRankUiModel
import com.madsam.otora.ui.components.DoubleCircleIndicator
import com.madsam.otora.ui.components.PopupTip
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
import androidx.compose.material3.HorizontalDivider
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
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
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
                colorScheme = colorScheme
            )
            
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = colorScheme.outlineVariant
            )
            
            // 图表区域
            Box(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                if (rankGraphData.isEmpty()) {
                    Text(
                        text = "Loading data...",
                        color = colorScheme.secondary,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 42.dp,
                                bottom = 42.dp
                            )
                    )

                    Spacer(
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
                                        fill = LineCartesianLayer.LineFill.single(fill(colorScheme.primary)),
                                        areaFill = LineCartesianLayer.AreaFill.single(
                                            fill(
                                                ShaderProvider.verticalGradient(
                                                    Color.Transparent.toArgb(),
                                                    colorScheme.primary.copy(alpha = 0.3f).toArgb()
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
                                    color = colorScheme.primary
                                ),
                                labelPosition = DefaultCartesianMarker.LabelPosition.Top,
                                guideline = rememberAxisGuidelineComponent(
                                    fill = fill(colorScheme.primary.copy(alpha = 0.3f))
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

                if (highestData.rank != "" || highestData.date.isNotEmpty()) {
                    Text(
                        text = buildAnnotatedString {
                            append("")
                            withStyle(
                                style = MaterialTheme.typography.titleSmall.toSpanStyle()
                                    .copy(color = colorScheme.primary)
                            ) {
                                append("${stringResource(id = R.string.highest_rank)}: #${highestData.rank}")
                            }
                            withStyle(
                                style = MaterialTheme.typography.bodySmall.toSpanStyle()
                                    .copy(color = colorScheme.secondary)
                            ) {
                                append(" (${highestData.date.split("T")[0]})")
                            }
                        },
                        color = colorScheme.onSurface,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(top = 16.dp, end = 15.dp, bottom = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun RankDataSection(
    cardData: OsuCardUiModel,
    colorScheme: ColorScheme
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 全球排名
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val globalRankText = buildAnnotatedString {
                append("")
                withStyle(
                    style = SpanStyle(
                        color = colorScheme.primary,
                        fontFamily = sarasaFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(cardData.rank)
                }
            }
            
            val globalRankPopupVisible = remember { MutableTransitionState(false) }
            Text(
                text = globalRankText,
                modifier = Modifier.clickable {
                    if (cardData.maniaModeGlobalRank.isNotEmpty()) {
                        globalRankPopupVisible.targetState = true
                    }
                }
            )
            
            PopupTip(
                text = cardData.maniaModeGlobalRank,
                color = colorScheme.onSurface,
                modifier = Modifier,
                showPopup = globalRankPopupVisible,
                alignment = Alignment.TopCenter
            )
            
            Text(
                text = stringResource(id = R.string.global_ranking),
                style = MaterialTheme.typography.bodySmall,
                color = colorScheme.onSurfaceVariant
            )
        }
        
        // 国家/地区排名
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val countryRankText = buildAnnotatedString {
                append("")
                withStyle(
                    style = SpanStyle(
                        color = colorScheme.secondary,
                        fontFamily = sarasaFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(cardData.countryRank)
                }
            }
            
            val countryRankPopupVisible = remember { MutableTransitionState(false) }
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
                        .height(16.dp)
                        .width(24.dp)
                )
                
                Text(
                    text = countryRankText,
                    modifier = Modifier.clickable {
                        if (cardData.maniaModeCountryRank.isNotEmpty()) {
                            countryRankPopupVisible.targetState = true
                        }
                    }
                )
            }
            
            PopupTip(
                text = cardData.maniaModeCountryRank,
                color = colorScheme.onSurface,
                modifier = Modifier,
                showPopup = countryRankPopupVisible,
                alignment = Alignment.TopCenter
            )
            
            Text(
                text = cardData.country,
                style = MaterialTheme.typography.bodySmall,
                color = colorScheme.onSurfaceVariant
            )
        }
    }
}