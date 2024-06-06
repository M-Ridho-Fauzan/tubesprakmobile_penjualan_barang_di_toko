package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.orderScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.R
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.itemScreen.ItemRow
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.itemScreen.ItemViewModel

@Composable
fun OrderScreen(modifier: Modifier = Modifier, navController: NavController) {

    val itemViewModel = hiltViewModel<ItemViewModel>()
    val items: List<Item> by itemViewModel.items.observeAsState(listOf())

    var selectedItems = remember { mutableStateListOf<Item>() }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)) {
        // Baris 1
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items.size) { index ->
                val item = items[index]
                val isSelected = remember { derivedStateOf { selectedItems.contains(item) } }

                ItemRow(
                    item = item,
                    onEditClick = {}, // Karena tidak diperlukan pada screen ini
                    onDeleteClick = {}, // Karena tidak diperlukan pada screen ini
                    onAddChartClick = {
                        if (isSelected.value) {
                            selectedItems.remove(item)
                        } else {
                            selectedItems.add(item)
                        }
                    },
                    showEditDeleteButtons = false
                )
                IconButton(onClick = {
                    if (isSelected.value) {
                        selectedItems.remove(item)
                    } else {
                        selectedItems.add(item)
                    }
                }) {
                    Icon(
                        painter = painterResource(
                            id = if (isSelected.value) R.drawable.baseline_checkout_24 else R.drawable.baseline_checkout2_24
                        ),
                        contentDescription = "Add to cart"
                    )
                }
            }
        }

        // Back System
        val totalItems = selectedItems.size
        val totalPrice = selectedItems.sumOf { it.price.toDouble() }

        // Baris 2
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Total Items: $totalItems")
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Total Price: $totalPrice")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = {
                // Handle checkout logic here
                navController.navigate("comingsoon")
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_checkout_24),
                    contentDescription = "Checkout Order"
                )
            }
        }
    }
}
