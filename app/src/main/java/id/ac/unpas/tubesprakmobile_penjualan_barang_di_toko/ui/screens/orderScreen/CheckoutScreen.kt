package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.orderScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem
//import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.orderScreen.CheckoutItemRow

//@Composable
//fun CheckoutScreen(
//    orderItems: List<OrderItem>,
//    onPaymentMethodChange: (String) -> Unit,
//    onCheckoutClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    val paymentMethods = listOf("Cash", "Credit Card", "Debit Card", "Transfer", "E-Wallet")
//    var selectedPaymentMethod by remember { mutableStateOf("Cash") }
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // Baris 1
//        LazyColumn(
//            modifier = Modifier.weight(1f)
//        ) {
//            items(orderItems.size) { index ->
//                val orderItem = orderItems[index]
//                CheckoutItemRow(
//                    item = orderItem.shopItemId,
//                    index = index + 1,
//                    quantity = orderItem.quantity
//                )
//            }
//        }
//
//        // Baris 2
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column(modifier = Modifier.weight(1f)) {
//                Text("Payment Method")
//                Dropdown(
//                    options = paymentMethods,
//                    value = selectedPaymentMethod,
//                    onValueChange = { selectedPaymentMethod = it },
//                    modifier = Modifier.fillMaxWidth()
//                )
//            }
//
//            Column(modifier = Modifier.weight(1f)) {
//                Text("Total Items: ${orderItems.sumOf { it.quantity }}")
//            }
//
//            Column(modifier = Modifier.weight(1f)) {
//                Text("Total Price: ${orderItems.sumOf { it.unitPrice.toDouble() * it.quantity }}")
//            }
//        }
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.End
//        ) {
//            Button(
//                onClick = {
//                    onPaymentMethodChange(selectedPaymentMethod)
//                    onCheckoutClick()
//                }
//            ) {
//                Text("Checkout")
//            }
//        }
//    }
//}