package com.superheros.mx.commons.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * SuperHeroTheme
 *
 * @author (c) 2022, UVI TECH SAPI De CV, KAVAK
 **/
private val DarkColorPalette = darkColorScheme(
    primary = GreenLight,
    onPrimary = Green,
    primaryContainer = GreenDark,
    onPrimaryContainer = GreenLight,
    secondary = BrownLight,
    onSecondary = Brown,
    secondaryContainer = BrownDark,
    onSecondaryContainer = BrownLight,
    tertiary = BlueAquaLight,
    onTertiary = BlueAqua,
    tertiaryContainer = BlueAquaDark,
    onTertiaryContainer = BlueAquaLight,
    background = BlackLight,
    onBackground = WhiteLight,
    surface = BlackLight,
    onSurface = WhiteLight,
    surfaceVariant = BrownSurfaceDark,
    onSurfaceVariant = BrownOnSurfaceDark,
    outline = BrownOutlineDark,
    outlineVariant = BrownOnOutlineDark
)

private val LightColorPalette = lightColorScheme(
    primary = Green,
    onPrimary = White,
    primaryContainer = GreenLight,
    onPrimaryContainer = Black,
    secondary = Brown,
    onSecondary = White,
    secondaryContainer = BrownLight,
    onSecondaryContainer = Black,
    tertiary = BlueAqua,
    onTertiary = White,
    tertiaryContainer = BlueAquaLight,
    onTertiaryContainer = Black,
    background = WhiteLight,
    onBackground = BlackLight,
    surface = WhiteLight,
    onSurface = BlackLight,
    surfaceVariant = BrownSurface,
    onSurfaceVariant = BrownOnSurface,
    outline = BrownOutline,
    outlineVariant = BrownOnOutline
)

@Composable
fun SuperHeroTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colorScheme = when {
        dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography= MaterialTheme.typography,
        shapes = shapes,
        content = content
    )
}