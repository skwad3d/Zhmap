package com.example.zhmap

fun parseObj(data: String): List<Triple<Float, Float, Float>> {
    return data.lines()
        .filter { it.startsWith("v ") }
        .map {
            val parts = it.split(" ")
            Triple(parts[1].toFloat(), parts[2].toFloat(), parts[3].toFloat())
        }
}
