package dev.ayameio.breathwork.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.ayameio.R
import dev.ayameio.breathwork.ui.components.BubbleIndicator
import dev.ayameio.breathwork.ui.components.SettingArc
import dev.ayameio.breathwork.ui.theme.PlaygroundTheme

@Preview(showSystemUi = true)
@Composable
fun SessionPreview() {
    PlaygroundTheme {
        SessionScreen()
    }
}

@Composable
fun SessionScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Box(modifier = modifier.fillMaxSize().padding(horizontal = 20.dp), contentAlignment = Alignment.TopCenter) {
        Column(modifier = modifier
            .fillMaxHeight()
            .padding(vertical = 50.dp), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
            SettingsView()
            BubbleIndicator()
            Button(onClick = {}) {
                Text("Begin", textAlign = TextAlign.Center)
            }
        }
    }
}

// This seems like a massive code duplication. Will fix later.
@Composable
fun SettingsView(
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel = viewModel(),
) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f)
            .height(205.dp)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Column(
            modifier = modifier.weight(1f).padding(horizontal = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = modifier,
                colors = CardDefaults.cardColors(),
                content = { Text(
                    modifier = modifier.padding(vertical = 5.dp, horizontal = 15.dp),
                    text = stringResource(id = R.string.tempo),
                    fontWeight = FontWeight.Medium
                ) }
            )
            SettingArc(value = settingsViewModel.tempoSliderValue, minValue = 1.5f, maxValue = 4f)
            Slider(
                value = settingsViewModel.tempoSliderValue,
                valueRange = 1.5f..4f,
                onValueChange = { settingsViewModel.updateTempo(it) },
                steps = 4
            )
        }
        Column(
            modifier = modifier.weight(1f).padding(horizontal = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = modifier,
                colors = CardDefaults.cardColors(),
                content = { Text(
                    modifier = modifier.padding(vertical = 5.dp, horizontal = 15.dp),
                    text = stringResource(id = R.string.breaths),
                    fontWeight = FontWeight.Medium
                ) }
            )
            SettingArc(value = settingsViewModel.breathsSliderValue, minValue = 20f, maxValue = 40f)
            Slider(
                value = settingsViewModel.breathsSliderValue,
                valueRange = 20f..40f,
                onValueChange = { settingsViewModel.updateBreaths(it) },
                steps = 19
            )
        }
        Column(
            modifier = modifier.weight(1f).padding(horizontal = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = modifier,
                colors = CardDefaults.cardColors(),
                content = { Text(
                    modifier = modifier.padding(vertical = 5.dp, horizontal = 15.dp),
                    text = stringResource(id = R.string.rounds),
                    fontWeight = FontWeight.Medium
                ) }
            )
            SettingArc(value = settingsViewModel.roundsSliderValue, minValue = 1f, maxValue = 10f)
            Slider(
                value = settingsViewModel.roundsSliderValue,
                valueRange = 1f..10f,
                onValueChange = { settingsViewModel.updateRounds(it) },
                steps = 9
            )
        }
    }
}