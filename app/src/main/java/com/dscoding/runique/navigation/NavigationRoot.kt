package com.dscoding.runique.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dscoding.auth.presentation.intro.IntroScreenRoot
import com.dscoding.auth.presentation.login.LoginScreenRoot
import com.dscoding.auth.presentation.register.RegisterScreenRoot

@Composable
fun NavigationRoot(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AuthDestination.ROOT_ROUTE
    ) {
        authGraph(navController)
        runGraph(navController)
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
            LoginScreenRoot(
                onSignUpClick = {
                    navController.navigate(AuthDestination.Register.route) {
                        popUpTo(AuthDestination.Login.route) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulLogin = {
                    navController.navigate(RunDestination.ROOT_ROUTE)
                }
            )
        }
    }
}

private fun NavGraphBuilder.runGraph(navController: NavHostController) {
    navigation(
        startDestination = RunDestination.Overview.route,
        route = RunDestination.ROOT_ROUTE
    ) {
        composable(RunDestination.Overview.route) {
            Text(text = "Run")
        }
    }
}