package com.rafaelcosta.carteirinhadigital2devest_b.feature.login.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    val usuario: String,
    val senha: String
)