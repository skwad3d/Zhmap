package com.example.zhmap

import android.os.Bundle
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageView = ImageView(this)
        setContentView(imageView)

        val objData = assets.open("model.obj").bufferedReader().use { it.readText() }
        val vertices = parseObj(objData)
        val bitmap = createHeightMap(vertices, 256, 256)

        imageView.setImageBitmap(bitmap)
    }
}
