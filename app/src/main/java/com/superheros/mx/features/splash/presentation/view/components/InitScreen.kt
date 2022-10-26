package com.superheros.mx.features.splash.presentation.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.superheros.mx.R
import com.superheros.mx.commons.ui.buttons.HeroButton
import com.superheros.mx.commons.ui.buttons.HeroTextButton
import com.superheros.mx.commons.utils.constants.SuperHeroConstants.HALF_VALUE

/**
 * SuperAppInitScreen
 *
 * @author (c) 2022, UVI TECH SAPI De CV, KAVAK
 **/
@Composable
fun initScreen(
    click: () -> Unit,
    walkThroughClick: () -> Unit,
) {

    val constraints = ConstraintSet {
        val iconApp = createRefFor("appIcon")
        val columnDesc = createRefFor("columnDesc")
        val centerVerticalGuideline = createGuidelineFromTop(HALF_VALUE)

        constrain(iconApp) {
            bottom.linkTo(centerVerticalGuideline, margin = 2.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(columnDesc) {
            top.linkTo(centerVerticalGuideline, margin = 8.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
    ConstraintLayout(
        constraints,
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "SuperHeros Logo",
            modifier = Modifier
                .layoutId("appIcon")
                .size(200.dp, 200.dp)
        )
        Column(
            modifier = Modifier
                .layoutId("columnDesc")
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = stringResource(id = R.string.splash_subtitle),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(32.dp))
            HeroButton(
                click = { click() },
                modifier = Modifier.layoutId("goHome"),
                isEnable = true,
                text = stringResource(id = R.string.go_to_home)
            )
            HeroTextButton(
                click = { walkThroughClick() },
                modifier = Modifier.layoutId("goWalkthrough"),
                text = stringResource(id = R.string.go_to_walkthrough)
            )
        }
    }
}

@Preview
@Composable
fun testInitScreen() {
    initScreen(
        click = { /*TODO*/ },
        walkThroughClick = { /*TODO*/ }
    )
}