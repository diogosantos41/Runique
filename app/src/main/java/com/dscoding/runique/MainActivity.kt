package com.dscoding.runique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dscoding.auth.presentation.intro.IntroScreenRoot
import com.dscoding.core.presentation.designsystem.AnalyticsIcon
import com.dscoding.core.presentation.designsystem.RuniqueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuniqueTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    IntroScreenRoot({}, {})
                }
            }
        }
    }
}