package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(modifier: Modifier = Modifier, onLoginClick: () -> Unit) {
    val username = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val openDialog = remember {
        mutableStateOf(false)
    }
    Column(modifier = modifier
        .fillMaxWidth()) {

        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
            OutlinedTextField(
                label = { Text(text = "Username") },
                modifier = Modifier.fillMaxWidth(),
                value = username.value, onValueChange = {
                    username.value = it
                })

            OutlinedTextField(
                label = { Text(text = "Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                value = password.value, onValueChange = {
                    password.value = it
                })

            Row {
                Button(modifier = Modifier.weight(5f), onClick = {
                    if (username.value == "admin" && password.value == "admin") {
                        onLoginClick()
                    } else {
                        openDialog.value = true
                    }

                }) {
                    Text(text = "Login")
                }

                Button(modifier = Modifier.weight(5f), onClick = {

                }) {
                    Text(text = "Batal")
                }
            }
        }

        if (openDialog.value) {
            AlertDialog(onDismissRequest = {
                openDialog.value = false
            }, confirmButton = {
                Button(onClick = {
                    username.value = ""
                    password.value = ""
                    openDialog.value = false
                }) {
                    Text(text = "OK")
                }
            }, title = {
                Text(text = "Login Gagal")
            }, text = {
                Text(text = "Username atau Password salah")
            })
        }

    }
}