package com.lekalina.starwars.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColors(
    primary = SlateGray,
    secondary = PurpleGrey80,
    primaryVariant = Pink80,
    surface = Black,
    onPrimary = Gold,
    onSurface = White
)

private val LightColorScheme = lightColors(
    primary = Black,
    secondary = PurpleGrey40,
    primaryVariant = Pink40,
    surface = White,
    onPrimary = Gold,
    onSurface = Black
)

@Composable
fun StarWarsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
            colors = colorScheme,
            typography = Typography,
            content = content
    )
}
