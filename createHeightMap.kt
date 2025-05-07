package com.example.zhmap

import android.graphics.Bitmap
import kotlin.math.roundToInt

fun createHeightMap(vertices: List<Triple<Float, Float, Float>>, width: Int, height: Int): Bitmap {
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

    val xs = vertices.map { it.first }
    val ys = vertices.map { it.second }
    val zs = vertices.map { it.third }

    val minX = xs.minOrNull() ?: 0f
    val maxX = xs.maxOrNull() ?: 1f
    val minY = ys.minOrNull() ?: 0f
    val maxY = ys.maxOrNull() ?: 1f
    val minZ = zs.minOrNull() ?: 0f
    val maxZ = zs.maxOrNull() ?: 1f

    for ((x, y, z) in vertices) {
        val px = ((x - minX) / (maxX - minX) * (width - 1)).roundToInt()
        val py = ((y - minY) / (maxY - minY) * (height - 1)).roundToInt()
        val gray = (((z - minZ) / (maxZ - minZ)) * 255).roundToInt()
        val color = (0xFF shl 24) or (gray shl 16) or (gray shl 8) or gray
        bitmap.setPixel(px, height - py - 1, color)
    }

    return bitmap
}
