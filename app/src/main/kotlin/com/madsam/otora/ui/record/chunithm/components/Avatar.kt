package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.data.chunithm.ui.model.ChunithmAvatarUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun AvatarLayout(
    chunithmAvatarUiModel: MutableStateFlow<ChunithmAvatarUiModel>
) {
    val avatarData by chunithmAvatarUiModel.collectAsState()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(10.dp))
            .scaledLayout(0.8f) // width: 224, height: 264
            .width(280.dp)
            .background(Red700)
    ) {
        Box(
            modifier = Modifier
                .size(width = 272.dp, height = 330.dp)
        ) {
            // Avatar Back
            Image(
                painter = rememberAsyncImagePainter(avatarData.back),
                contentDescription = "Avatar Back",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .size(272.dp, 294.dp)
                    .offset(y = 25.dp)
                    .zIndex(100f)
            )

            // Left Foot
            Box(
                modifier = Modifier
                    .size(width = 42.dp, height = 52.dp)
                    .offset(x = 84.dp, y = 280.dp)
                    .clipToBounds()
                    .zIndex(101f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.footL),
                    contentDescription = "Avatar Skinfoot Left",
                    modifier = Modifier
                        .offset(x = 43.dp, y = (-102).dp)
                        .requiredSize(128.dp, 256.dp)
                )
            }

            // Right Foot
            Box(
                modifier = Modifier
                    .size(width = 42.dp, height = 52.dp)
                    .offset(x = 147.dp, y = 280.dp)
                    .clipToBounds()
                    .zIndex(102f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.footR),
                    contentDescription = "Avatar Skinfoot Right",
                    modifier = Modifier
                        .offset(x = 1.dp, y = (-102).dp)
                        .requiredSize(128.dp, 256.dp)
                )
            }

            // Skin (avatar_skin)
            Box(
                modifier = Modifier
                    .size(width = 128.dp, height = 204.dp)
                    .offset(x = 72.dp, y = 93.dp)
                    .clipToBounds()
                    .zIndex(104f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.skin),
                    contentDescription = "Avatar Skin",
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Wear (avatar_wear)
            Box(
                modifier = Modifier
                    .size(width = 258.dp, height = 218.dp)
                    .offset(x = 7.dp, y = 106.dp)
                    .clipToBounds()
                    .zIndex(105f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.wear),
                    contentDescription = "Avatar Wear",
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Face (avatar_face)
            Box(
                modifier = Modifier
                    .size(width = 58.dp, height = 64.dp)
                    .offset(x = 107.dp, y = 100.dp)
                    .clipToBounds()
                    .zIndex(106f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.face),
                    contentDescription = "Avatar Face",
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Face Cover (avatar_faceCover)
            Box(
                modifier = Modifier
                    .size(width = 116.dp, height = 104.dp)
                    .offset(x = 78.dp, y = 96.dp)
                    .clipToBounds()
                    .zIndex(107f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.faceCover),
                    contentDescription = "Avatar Face Cover",
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Head (avatar_head)
            Box(
                modifier = Modifier
                    .size(width = 200.dp, height = 150.dp)
                    .offset(x = 37.dp, y = 28.dp)
                    .clipToBounds()
                    .zIndex(108f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.head),
                    contentDescription = "Avatar Head",
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Right Hand (avatar_hand_r)
            Box(
                modifier = Modifier
                    .size(width = 36.dp, height = 72.dp)
                    .offset(x = 52.dp, y = 178.dp)
                    .clipToBounds()
                    .zIndex(109f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.handR),
                    contentDescription = "Avatar Right Hand",
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Left Hand (avatar_hand_l)
            Box(
                modifier = Modifier
                    .size(width = 36.dp, height = 72.dp)
                    .offset(x = 184.dp, y = 178.dp)
                    .clipToBounds()
                    .zIndex(109f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.handL),
                    contentDescription = "Avatar Left Hand",
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Right Item (avatar_item_r)
            Box(
                modifier = Modifier
                    .size(width = 100.dp, height = 272.dp)
                    .offset(x = 9.dp, y = 50.dp)
                    .graphicsLayer { rotationZ = -5f }
                    .clipToBounds()
                    .zIndex(109f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.itemR),
                    contentDescription = "Avatar Right Item",
                    modifier = Modifier
                        .offset(x = 50.dp)
                        .requiredSize(200.dp, 272.dp)
                )
            }

            // Left Item (avatar_item_l)
            Box(
                modifier = Modifier
                    .size(width = 100.dp, height = 272.dp)
                    .offset(x = 163.dp, y = 50.dp)
                    .graphicsLayer { rotationZ = 5f }
                    .clipToBounds()
                    .zIndex(110f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(avatarData.itemL),
                    contentDescription = "Avatar Left Item",
                    modifier = Modifier
                        .offset(x = (-50).dp)
                        .requiredSize(200.dp, 272.dp)
                )
            }
        }
    }
}

fun Modifier.scaledLayout(scale: Float): Modifier = this
    .graphicsLayer(scaleX = scale, scaleY = scale, transformOrigin = TransformOrigin(0f, 0f))
    .layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val scaledWidth = (placeable.width * scale).toInt()
        val scaledHeight = (placeable.height * scale).toInt()
        layout(scaledWidth, scaledHeight) {
            placeable.placeRelative(0, 0)
        }
    }