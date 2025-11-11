package com.madsam.otora.data.chunithm.remote.model

internal data class ChunithmMapDTO(
    val title: String,
    val currentPage: Int,
    val totalPages: Int,
    val areas: List<ChuniMapArea>
) {
    internal data class ChuniMapArea(
        val imageUrl: String?,
        val remain: Int,
        val skillSeed: String?
    )
}
