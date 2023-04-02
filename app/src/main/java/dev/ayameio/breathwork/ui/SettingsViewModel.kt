package dev.ayameio.breathwork.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SettingsState(
    val tempoValue:     Float = 2f,
    val breathsValue:   Float = 25f,
    val roundsValue:    Float = 3f
)

class SettingsViewModel: ViewModel() {
    private val _settingsState = MutableStateFlow(SettingsState())
    val settingsState: StateFlow<SettingsState> = _settingsState.asStateFlow()

    var tempoSliderValue    by mutableStateOf(settingsState.value.tempoValue)
        private set
    var breathsSliderValue  by mutableStateOf(settingsState.value.breathsValue)
        private set
    var roundsSliderValue   by mutableStateOf(settingsState.value.roundsValue)
        private set

    fun updateTempo(value: Float) {
        tempoSliderValue = value
    }
    fun updateBreaths(value: Float) {
        breathsSliderValue = value
    }
    fun updateRounds(value: Float) {
        roundsSliderValue = value
    }
}