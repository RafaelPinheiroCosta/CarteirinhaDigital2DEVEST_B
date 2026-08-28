package com.rafaelcosta.carteirinhadigital2devest_b.feature.login.presentation

import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.domain.model.UsuarioLogado

data class LoginUIState(
    val usuario:String = "",
    val senha:String = "",
    val erroMessage: String? = null,
    val isLoading: Boolean = false,
    val usuarioLogado: UsuarioLogado? = null
) {
    val loginRealizado: Boolean
        get() = usuarioLogado != null
}