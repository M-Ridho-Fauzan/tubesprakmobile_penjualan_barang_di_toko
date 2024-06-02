package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier, onLihat: () -> Unit) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Selamat Datang", modifier = Modifier.fillMaxWidth())
        Button(onClick = {
            navController.navigate(NavScreen.Add.route)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Tambah")
        }
        Button(onClick = {
            onLihat()
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Lihat")
        }
    }
}