package com.artables.pickure

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get device dimensions
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val bitmap = Bitmap.createBitmap(
            displayMetrics.widthPixels,
            displayMetrics.heightPixels,
            Bitmap.Config.ARGB_4444
        )
        val canvas = Canvas(bitmap)

        // canvas background color
        canvas.drawARGB(255, 78, 168, 186)

        var paint = Paint()
        paint.color = Color.parseColor("#FFFFFF")
        paint.strokeWidth = 30F
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.isDither = true

        var center_x = (displayMetrics.widthPixels / 2).toFloat()
        var center_y = (displayMetrics.heightPixels / 2).toFloat()
        var radius = 200F

        // draw circle
        canvas.drawCircle(center_x, center_y, radius, paint)
        // now bitmap holds the updated pixels

        val oval = RectF()
        oval.set(center_x - radius, center_y - radius, center_x + radius, center_y + radius)

        var turquoisePaint = Paint()
        turquoisePaint.color = Color.parseColor("#A56FCE")
        turquoisePaint.style = Paint.Style.FILL
        turquoisePaint.isAntiAlias = true
        turquoisePaint.isDither = true

        val orangePaint = Paint()
        orangePaint.color = Color.parseColor("#EAC440")
        orangePaint.style = Paint.Style.FILL
        orangePaint.isAntiAlias = true
        orangePaint.isDither = true

        val yellowPaint = Paint()
        yellowPaint.color = Color.parseColor("#D03214")
        yellowPaint.style = Paint.Style.FILL
        yellowPaint.isAntiAlias = true
        yellowPaint.isDither = true


        val hotPinkPaint = Paint()
        hotPinkPaint.color = Color.parseColor("#AE3201")
        hotPinkPaint.style = Paint.Style.FILL
        hotPinkPaint.isAntiAlias = true
        hotPinkPaint.isDither = true


        canvas.drawArc(oval, 0F, 90F, true, turquoisePaint)

        canvas.drawArc(oval, 90F, 90F, true, orangePaint)

        canvas.drawArc(oval, 180F, 90F, true, yellowPaint)

        canvas.drawArc(oval, 270F, 90F, true, hotPinkPaint)


        // set bitmap as background to ImageView
        imageV.background = BitmapDrawable(resources, bitmap)

    }
}
