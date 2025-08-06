package com.madsam.otora.ui.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.madsam.otora.core.theme.OtogeTrackerTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OtogeTrackerTheme {
                SettingsScreen(
                    onNavigateBack = { finish() }
                )
            }
        }
    }
}
