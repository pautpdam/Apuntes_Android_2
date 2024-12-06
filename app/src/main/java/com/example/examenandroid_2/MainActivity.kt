package com.example.examenandroid_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var imagen = findViewById<LottieAnimationView>(R.id.lottieAnimation)
        var like = false

        imagen.setOnClickListener{
            like = animacion(imagen, R.raw.apple_event, like)
        }
    }

    fun animacion(imageView: LottieAnimationView, animacion: Int, like:Boolean):Boolean {
        if (!like) {
            imageView.setAnimation(animacion)
            imageView.playAnimation()
        } else {
            imageView.setImageResource(R.drawable.corazon)
        }

        return !like
    }
}