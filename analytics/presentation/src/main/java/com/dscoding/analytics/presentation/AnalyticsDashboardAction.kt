package com.dscoding.analytics.presentation

sealed interface AnalyticsDashboardAction {
    data object OnBackClick: AnalyticsDashboardAction
}