package com.superheros.mx.features.splash.presentation.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.superheros.mx.commons.ui.BasicsSuperHeroTheme

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsSuperHeroTheme {
                // A surface container using the 'background' color from the theme
                Text(text = "Superheros")
            }
        }
    }
}