package com.example.statemanagementwithviewmodel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statemanagementwithviewmodel.ui.theme.StateManagementWithViewModelTheme

class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateManagementWithViewModelTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    contentAlignment = Alignment.Center
                ) {
                    MyScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun MyScreen(
    viewModel: MainViewModel
) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MyTextField(
            label = "Username",
            value = viewModel.username,
            onValueChanged = { viewModel.onUsernameChanged(it) })
        MyTextField(
            label = "Password",
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = viewModel.password,
            onValueChanged = { viewModel.onPasswordChanged(it) }
        )
        Button(
            onClick = {
                Toast.makeText(context, "Hello, ${viewModel.username}", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            enabled = viewModel.username.isNotBlank() && viewModel.password.isNotBlank()
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun MyTextField(
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isSingleLine: Boolean = true,
    value: String,
    onValueChanged: (String) -> Unit
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = label) },
        singleLine = isSingleLine,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateManagementWithViewModelTheme {

    }
}