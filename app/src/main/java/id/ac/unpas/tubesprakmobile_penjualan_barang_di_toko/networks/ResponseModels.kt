package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks

import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Order
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Todo
//===============
data class GetResponsesTodo(
    val data: List<Todo>
)

data class PostResponseTodo(
    val message: String,
    val success: Boolean,
    val data: Todo? // '?' = Berarti data bisa di kirim nilai null
)

data class DeleteResponseTodo(
    val message: String,
    val success: Boolean,
)
//===============
data class GetResponsesItem(
    val items: List<Item>
)

data class PostResponseItem(
    val message: String,
    val success: Boolean,
    val item: Item
)

data class DeleteResponseItem(
    val message: String,
    val success: Boolean
)
//===============
data class GetResponsesOrder(
    val orders: List<Order>
)

data class PostResponseOrder(
    val message: String,
    val success: Boolean,
    val order: Order
)

data class DeleteResponseOrder(
    val message: String,
    val success: Boolean
)
//===============
data class GetResponsesOrderItem(
    val orderItems: List<OrderItem>
)

data class PostResponseOrderItem(
    val message: String,
    val success: Boolean,
    val orderItem: OrderItem
)

data class DeleteResponseOrderItem(
    val message: String,
    val success: Boolean
)
//===============