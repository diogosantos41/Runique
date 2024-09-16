package com.dscoding.runique.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.dscoding.auth.presentation.intro.IntroScreenRoot
import com.dscoding.auth.presentation.login.LoginScreenRoot
import com.dscoding.auth.presentation.register.RegisterScreenRoot
import com.dscoding.run.presentation.active_run.ActiveRunScreenRoot
import com.dscoding.run.presentation.active_run.service.ActiveRunService
import com.dscoding.run.presentation.run_overview.RunOverviewScreenRoot
import com.dscoding.runique.MainActivity

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean,
    onAnalyticsClick: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) {
            RunDestination.ROOT_ROUTE
        } else {
            AuthDestination.ROOT_ROUTE
        }
    ) {
        authGraph(navController)
        runGraph(navController, onAnalyticsClick)
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

private fun NavGraphBuilder.runGraph(
    navController: NavHostController,
    onAnalyticsClick: () -> Unit
) {
    navigation(
        startDestination = RunDestination.Overview.route,
        route = RunDestination.ROOT_ROUTE
    ) {
        composable(route = RunDestination.Overview.route) {
            RunOverviewScreenRoot(
                onStartRunClick = {
                    navController.navigate(RunDestination.ActiveRun.route)
                },
                onAnalyticsClick = onAnalyticsClick,
                onLogoutClick = {
                    navController.navigate(AuthDestination.ROOT_ROUTE) {
                        popUpTo(RunDestination.ROOT_ROUTE) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = RunDestination.ActiveRun.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "runique://active_run"
                })
        ) {
            val context = LocalContext.current
            ActiveRunScreenRoot(
                onBackClick = {
                    navController.navigateUp()
                },
                onFinish = {
                    navController.navigateUp()
                },
                onServiceToggle = { shouldServiceRun ->
                    if (shouldServiceRun) {
                        context.startService(
                            ActiveRunService.createStartIntent(
                                context = context,
                                activityClass = MainActivity::class.java
                            )
                        )
                    } else {
                        context.startService(
                            ActiveRunService.createStopIntent(
                                context = context
                            )
                        )
                    }
                }
            )
        }
    }
}