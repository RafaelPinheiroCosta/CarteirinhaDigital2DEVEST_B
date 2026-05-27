package com.rafaelcosta.carteirinhadigital2devest_b.app.navigation

sealed class Routes (val route: String){

    data object Login : Routes("login")
    data object Carteirinha : Routes("carteirinha")

}