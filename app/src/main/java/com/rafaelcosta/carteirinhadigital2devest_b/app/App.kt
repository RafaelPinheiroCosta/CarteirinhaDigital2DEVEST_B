package com.rafaelcosta.carteirinhadigital2devest_b.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.rafaelcosta.carteirinhadigital2devest_b.app.navigation.AppNavHost
import com.rafaelcosta.carteirinhadigital2devest_b.core.designsystem.theme.CarteirinhaDigital2DEVEST_BTheme

@Composable
fun App() {
    CarteirinhaDigital2DEVEST_BTheme() {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController,
        )
    }
}