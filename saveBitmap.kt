package com.example.Zhmap

import android.graphics.Bitmap
import android.os.Environment
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream

fun saveBitmap(bitmap: Bitmap) {
    val filename = "heightmap_${System.currentTimeMillis()}.png"
    val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
    val file = File(dir, filename)

    FileOutputStream(file).use {
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
    }

    Toast.makeText(
        null,
        "Saved to ${file.absolutePath}",
        Toast.LENGTH_LONG
    ).show()
}
