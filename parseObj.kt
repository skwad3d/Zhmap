package com.example.heightmapapp

import java.io.InputStream

data class Vertex(val x: Float, val y: Float, val z: Float)

fun parseObj(input: InputStream): List<Vertex> {
    val reader = BufferedReader(InputStreamReader(input))
    val vertices = mutableListOf<Vertex>()

    reader.forEachLine { line ->
        if (line.startsWith("v ")) {
            val parts = line.split(" ")
            val x = parts[1].toFloat()
            val y = parts[2].toFloat()
            val z = parts[3].toFloat()
            vertices.add(Vertex(x, y, z))
        }
    }
    return vertices
}
