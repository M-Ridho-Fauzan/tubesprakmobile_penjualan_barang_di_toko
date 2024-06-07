package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item

@Composable
fun HomeScreen(navController: NavController, items: List<Item>, modifier: Modifier = Modifier, onLihat: () -> Unit) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "", modifier = Modifier.fillMaxWidth())

        val totalItem = items.size

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .background(color = MaterialTheme.colorScheme.primary) // Tambahkan background hitam
        ) {
            Column(modifier = Modifier.weight(1f)) {
//                Text(text = "Total Item di DB: $totalItem", color = Color.Black)
            }
        }

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