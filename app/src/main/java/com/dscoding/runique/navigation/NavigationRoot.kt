package com.dscoding.runique.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dscoding.auth.presentation.intro.IntroScreenRoot
import com.dscoding.auth.presentation.register.RegisterScreenRoot

@Composable
fun NavigationRoot(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AuthDestination.ROOT_ROUTE
    ) {
        authGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = AuthDestination.Intro.route,
        route = AuthDestination.ROOT_ROUTE
    ) {
        composable(route = AuthDestination.Intro.route) {
            IntroScreenRoot(
                onSignUpClick = {
                    navController.navigate(AuthDestination.Register.route)
                },
                onSignInClick = {
                    navController.navigate(AuthDestination.Login.route)
                }
            )
        }
        composable(route = AuthDestination.Register.route) {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate(AuthDestination.Login.route) {
                        popUpTo(AuthDestination.Register.route) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate(AuthDestination.Login.route)
                }
            )
        }
        composable(route = AuthDestination.Login.route) {
            Text(text = "Login")
        }
    }
}