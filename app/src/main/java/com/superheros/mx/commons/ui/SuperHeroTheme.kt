package com.superheros.mx.commons.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * SuperHeroTheme
 *
 * @author (c) 2022, UVI TECH SAPI De CV, KAVAK
 **/
private val DarkColorPalette = darkColors(
    primary = BlueGrey_700,
    primaryVariant = BlueGreyDark_700,
    secondary = Cyan,
    surface = Black_Dark,
    background = Black_Dark,
    error = Red,
    onPrimary = White,
    onSecondary = White,
    onSurface = WhiteLight,
    onBackground = WhiteLight,
    onError = White
)

private val LightColorPalette = lightColors(
    primary = BlueGrey_100,
    primaryVariant = BlueGreyDark_100,
    secondary = Cyan,
    surface = White,
    background = White,
    error = Red,
    onPrimary = Black,
    onSecondary = White,
    onSurface = Black,
    onBackground = Black,
    onError = White
)

val typo = Typography(
    body1 =  TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp,
    ),
)

@Composable
fun SuperHeroTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography= MaterialTheme.typography,
        shapes = shapes,
        content = content
    )
}