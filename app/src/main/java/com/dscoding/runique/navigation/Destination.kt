package com.dscoding.runique.navigation


sealed class Destination(val route: String)

sealed class AuthDestination(route: String) : Destination(route) {

    companion object {
        const val ROOT_ROUTE = "auth"
    }

    data object Intro : AuthDestination("auth_intro")
    data object Register : AuthDestination("auth_register")
    data object Login : AuthDestination("auth_login")
}

sealed class RunDestination(route: String) : Destination(route) {

    companion object {
        const val ROOT_ROUTE = "run"
    }

    data object Overview : RunDestination("run_overview")
    data object ActiveRun : RunDestination("active_run")
}
