package dev.ayameio.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.ayameio.PlaygroundAppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: PlaygroundAppViewModel
) {
    var nameValue: String by remember { mutableStateOf("") }
    var emailValue: String by remember { mutableStateOf("") }

    val inputWidth = 260.dp
    val spacerHeight = 30.dp

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Onboard Screen", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(spacerHeight))
        OutlinedTextField(
            modifier = modifier.width(inputWidth),
            value = nameValue,
            onValueChange = { nameValue = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
            singleLine = true,
            label = { Text(text = "Real Name") },
            leadingIcon = { (Icon(imageVector = Icons.Filled.Face, contentDescription = "name")) }
        )
        OutlinedTextField(
            modifier = modifier.width(inputWidth),
            value = emailValue,
            onValueChange = { emailValue = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            label = { Text(text = "Email Address") },
            leadingIcon = { (Icon(imageVector = Icons.Filled.Email, contentDescription = "email")) }
        )
        Spacer(modifier = Modifier.height(spacerHeight))
        Button(onClick = {
            viewModel.passOnboardStage()
            navController.navigate("home")
        }, ) {
            Text("Enter App", textAlign = TextAlign.Center)
        }
    }
}