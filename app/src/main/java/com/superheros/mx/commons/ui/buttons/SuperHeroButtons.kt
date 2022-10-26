package com.superheros.mx.commons.ui.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

/**
 * SuperHeroButtons
 *
 * @author (c) 2022, UVI TECH SAPI De CV, KAVAK
 **/
@Composable
fun HeroButton(
    click: () -> Unit,
    modifier: Modifier = Modifier,
    isEnable: Boolean,
    text: String
) {
    Button(
        onClick = { click() },
        enabled = isEnable,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun HeroOutlineButton(
    click: () -> Unit,
    modifier: Modifier = Modifier,
    isEnable: Boolean,
    text: String
) {
    OutlinedButton(
        onClick = { click() },
        enabled = isEnable,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun HeroIconTextButton(
    click: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector = Icons.Filled.Favorite,
    spaceIcon: Dp = ButtonDefaults.IconSpacing
) {
    Button(
        onClick = { click() },
        modifier = modifier
    ) {
        Icon(
            icon,
            contentDescription = "Localized description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(spaceIcon))
        Text(text = text, color = MaterialTheme.colorScheme.onPrimary)
    }
}

@Composable
fun HeroTextButton(
    click: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
) {
    TextButton(
        onClick = { click() },
        modifier = modifier
    ) {
        Text(text = text, color = MaterialTheme.colorScheme.primary)
    }
}

@Preview
@Composable
fun testAnyButton() {
    HeroOutlineButton(click = { /*TODO*/ }, isEnable = true, text = "Click me")
}