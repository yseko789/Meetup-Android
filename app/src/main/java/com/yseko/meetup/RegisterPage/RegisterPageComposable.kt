package com.yseko.meetup.RegisterPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yseko.meetup.network.StoreAccessToken
import kotlinx.coroutines.launch


@Composable
fun RegisterScreen(
    viewModel: RegisterPageViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = StoreAccessToken(context)

    var token = dataStore.getBearerToken.collectAsState(initial = "")

    Column(
        modifier = modifier
    ){
        OutlinedTextField(
            value = viewModel.email,
            onValueChange = {viewModel.email = it},
            label = {Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            value = viewModel.username,
            onValueChange = {viewModel.username = it},
            label = {Text("Username")}
        )
        OutlinedTextField(
            value = viewModel.password,
            onValueChange = {viewModel.password = it},
            label = {Text("Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Button(
            onClick = {
                viewModel.registerUser()
                scope.launch {
                    dataStore.saveBearerToken(viewModel.token)
                }
            }
        ) {
            Text(text = "Register")
        }
//        Text(text = viewModel.token)

        token.value?.let { Text(text = it) }
    }
}