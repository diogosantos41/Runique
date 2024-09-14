@file:OptIn(ExperimentalMaterial3Api::class)

package com.dscoding.run.presentation.active_run

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dscoding.core.presentation.designsystem.RuniqueTheme
import com.dscoding.core.presentation.designsystem.StartIcon
import com.dscoding.core.presentation.designsystem.StopIcon
import com.dscoding.core.presentation.designsystem.components.RuniqueFloatingActionButton
import com.dscoding.core.presentation.designsystem.components.RuniqueScaffold
import com.dscoding.core.presentation.designsystem.components.RuniqueToolbar
import com.dscoding.run.presentation.R
import com.dscoding.run.presentation.active_run.components.RunDataCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActiveRunScreenRoot(
    onBackClick: () -> Unit,
    viewModel: ActiveRunViewModel = koinViewModel()
) {
    ActiveRunScreen(state = viewModel.state, onAction = { action ->
        when (action) {
            is ActiveRunAction.OnBackClick -> onBackClick()
            else -> Unit
        }
        viewModel.onAction(action)
    })
}


@Composable
fun ActiveRunScreen(
    state: ActiveRunState, onAction: (ActiveRunAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    RuniqueScaffold(withGradient = false, topAppBar = {
        RuniqueToolbar(showBackButton = true,
            title = stringResource(id = R.string.active_run),
            scrollBehavior = scrollBehavior,
            onBackClick = { onAction(ActiveRunAction.OnBackClick) })
    }, floatingActionButton = {
        RuniqueFloatingActionButton(icon = if (state.shouldTrack) {
            StopIcon
        } else {
            StartIcon
        }, iconSize = 20.dp, contentDescription = if (state.shouldTrack) {
            stringResource(id = R.string.pause_run)
        } else {
            stringResource(id = R.string.start_run)
        }, onClick = { onAction(ActiveRunAction.OnToggleRunClick) })
    }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            RunDataCard(
                elapsedTime = state.elapsedTime,
                runData = state.runData,
                modifier = Modifier
                    .padding(16.dp)
                    .padding(padding)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun ActiveRunScreenPreview() {
    RuniqueTheme {
        ActiveRunScreen(state = ActiveRunState(), onAction = {})
    }
}