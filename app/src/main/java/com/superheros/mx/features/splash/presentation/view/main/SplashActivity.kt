package com.superheros.mx.features.splash.presentation.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.superheros.mx.commons.ui.theme.SuperHeroTheme
import com.superheros.mx.features.splash.presentation.view.components.initScreen
import com.superheros.mx.features.splash.presentation.viewModel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        // Set up an OnPreDrawListener to the root view.
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    // Check if the initial data is ready.
                    return if (viewModel.isLoading.value) {
                        // The content is ready; start drawing.
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        // The content is not ready; suspend.
                        false
                    }
                }
            }
        )

        setContent {
            SuperHeroTheme {
                IniScreen()
            }
        }
    }

    @Preview
    @Composable
    private fun IniScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        ) {
            initScreen(
                click = { doToast() },
                walkThroughClick = { goWalkthrough() }
            )
        }
    }

    private fun doToast() {
        Toast.makeText(this@SplashActivity, "Click", Toast.LENGTH_LONG).show()
    }

    private fun goWalkthrough() {
        Toast.makeText(this@SplashActivity, "Click", Toast.LENGTH_LONG).show()
    }
}