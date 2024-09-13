package com.dscoding.runique.navigation


sealed class Destination(val route: String)

sealed class AuthDestination(route: String) : Destination(route) {

    companion object {
        const val ROOT_ROUTE = "auth_destination"
    }

    data object Intro : AuthDestination("auth_intro_destination")
    data object Register : AuthDestination("auth_register_destination")
    data object Login : AuthDestination("auth_login_destination")
}
