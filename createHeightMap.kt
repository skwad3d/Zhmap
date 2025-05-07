package com.example.heightmapapp

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

fun createHeightMap(vertices: List<Vertex>, width: Int, height: Int): Bitmap {
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    val paint = Paint()

    // Normalize coordinates
    val minX = vertices.minOf { it.x }
    val maxX = vertices.maxOf { it.x }
    val minY = vertices.minOf { it.y }
    val maxY = vertices.maxOf { it.y }
    val minZ = vertices.minOf { it.z }
    val maxZ = vertices.maxOf { it.z }

    for (v in vertices) {
        val x = ((v.x - minX) / (maxX - minX) * (width - 1)).toInt()
        val y = ((v.y - minY) / (maxY - minY) * (height - 1)).toInt()
        val zNorm = ((v.z - minZ) / (maxZ - minZ))
        val gray = (zNorm * 255).toInt().coerceIn(0, 255)
        paint.color = Color.rgb(gray, gray, gray)
        canvas.drawPoint(x.toFloat(), y.toFloat(), paint)
    }

    return bitmap
}
