package com.rafaelcosta.carteirinhadigital2devest_b.app.navigation

import kotlinx.serialization.Serializable

sealed class Routes (val route: String){

    @Serializable
    data object Login : Routes("login")
    @Serializable
    data object Carteirinha : Routes("carteirinha")
    @Serializable
    data object HomeAluno : Routes("homeAluno")
    @Serializable
    data object UCAluno : Routes("ucAluno")

}