package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.orderScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Order
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.ItemRepository
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.OrderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID
import javax.inject.Inject

//@HiltViewModel
//class CheckoutViewModel @Inject constructor(
//    private val orderRepository: OrderRepository,
//    private val itemRepository: ItemRepository
//) : ViewModel() {
//
//    private val _orderItems = mutableStateListOf<OrderItem>()
//    val orderItems: List<OrderItem> get() = _orderItems
//
//    private val _orderSummary = MutableStateFlow<OrderSummary?>(null)
//    val orderSummary: StateFlow<OrderSummary?> = _orderSummary
//
//    fun addToOrder(item: Item) {
//        val existingOrderItem = _orderItems.find { it.shopItemId == item.id }
//        if (existingOrderItem != null) {
//            _orderItems.remove(existingOrderItem)
//            _orderItems.add(existingOrderItem.copy(quantity = existingOrderItem.quantity + 1))
//        } else {
//            _orderItems.add(
//                OrderItem(
//                    id = UUID.randomUUID().toString(),
//                    shopOrderId = "", // Set the shopOrderId later
//                    shopItemId = item.id,
//                    unitPrice = item.price.toString(),
//                    quantity = 1
//                )
//            )
//        }
//        updateOrderSummary()
//    }
//
//    fun removeFromOrder(item: Item) {
//        val existingOrderItem = _orderItems.find { it.shopItemId == item.id }
//        if (existingOrderItem != null) {
//            if (existingOrderItem.quantity > 1) {
//                _orderItems.remove(existingOrderItem)
//                _orderItems.add(existingOrderItem.copy(quantity = existingOrderItem.quantity - 1))
//            } else {
//                _orderItems.remove(existingOrderItem)
//            }
//        }
//        updateOrderSummary()
//    }
//
//    private fun updateOrderSummary() {
//        val totalItems = _orderItems.sumOf { it.quantity }
//        val totalPrice = _orderItems.sumOf { it.unitPrice.toDouble() * it.quantity }
//        _orderSummary.value = OrderSummary(totalItems, totalPrice)
//    }
//
//    fun checkout(paymentMethod: String) {
//        val orderId = UUID.randomUUID().toString()
//        val orderDate = getCurrentDate()
//        val totalPrice = orderSummary.value?.totalPrice ?: 0.0
//        val order = Order(
//            id = orderId,
//            orderDate = orderDate,
//            totalPrice = totalPrice.toString(),
//            paymentMethod = paymentMethod,
//            remarks = ""
//        )
//
//        viewModelScope.launch {
//            orderRepository.insert(
//                order,
//                onSuccess = {
//                    _orderItems.forEach { orderItem ->
//                        orderRepository.insertOrderItem(
//                            orderItem.copy(shopOrderId = orderId),
//                            onSuccess = {
//                                itemRepository.updateStock(
//                                    orderItem.shopItemId,
//                                    -orderItem.quantity,
//                                    onSuccess = {},
//                                    onError = { /* Handle error */ }
//                                )
//                            },
//                            onError = { /* Handle error */ }
//                        )
//                    }
//                    _orderItems.clear()
//                    updateOrderSummary()
//                },
//                onError = { /* Handle error */ }
//            )
//        }
//    }
//
//    private fun getCurrentDate(): String {
//        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
//        return dateFormat.format(Date())
//    }
//
//    data class OrderSummary(
//        val totalItems: Int,
//        val totalPrice: Double
//    )
//}