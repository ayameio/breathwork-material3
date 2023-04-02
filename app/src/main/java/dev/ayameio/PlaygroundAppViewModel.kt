package dev.ayameio

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlaygroundAppViewModel: ViewModel() {
    private val _passedOnboardStage =  MutableStateFlow(false)
    val passedOnboardStage: StateFlow<Boolean> = _passedOnboardStage.asStateFlow()

    var passed by mutableStateOf(passedOnboardStage.value)
        private set
    fun passOnboardStage() {
        passed = true
    }
}