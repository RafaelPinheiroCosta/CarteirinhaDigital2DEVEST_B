package com.rafaelcosta.carteirinhadigital2devest_b.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rafaelcosta.carteirinhadigital2devest_b.app.session.SessionViewModel
import com.rafaelcosta.carteirinhadigital2devest_b.feature.carteirinha.presetantion.screen.CarteirinhaScreen
import com.rafaelcosta.carteirinhadigital2devest_b.feature.home_aluno.presentation.screen.HomeScreen
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.presentation.screen.LoginScreen
import com.rafaelcosta.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    sessionViewModel: SessionViewModel = viewModel()
) {
    val usuarioLogado by sessionViewModel.usuarioLogado.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {
            LoginScreen(
                navController=navController,
                onLoginSucesso = {
                    usuario->
                        sessionViewModel.setUsuarioLogado(usuario)
                    navController.navigate(Routes.HomeAluno.route)
                }
            )
        }
        composable(Routes.Carteirinha.route) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                CarteirinhaScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
        composable(Routes.HomeAluno.route) {
            val usuario = usuarioLogado
            if(usuario==null){
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }
            }else {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        composable(Routes.UCAluno.route) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                UnidadeCurricularScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}