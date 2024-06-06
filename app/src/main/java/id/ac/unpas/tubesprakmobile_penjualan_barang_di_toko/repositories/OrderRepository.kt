package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories

import androidx.annotation.WorkerThread
import com.skydoves.sandwich.message
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Order
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.OrderApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.OrderItemApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.OrderDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.OrderItemDao
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val orderApi: OrderApi,
    private val orderItemApi: OrderItemApi,
    private val orderDao: OrderDao,
    private val orderItemDao: OrderItemDao
) {

    @WorkerThread
    fun loadOrders(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val orderList: List<Order> = orderDao.findAll()
        orderApi.findAll()
            .suspendOnSuccess {
                data.whatIfNotNull {
                    orderDao.upsert(it.orders)
                    val localList = orderDao.findAll()
                    emit(localList)
                    onSuccess()
                }
            }
            .suspendOnError {
                emit(orderList)
                onError(message())
            }
            .suspendOnException {
                emit(orderList)
                onError(message())
            }
    }

//    suspend fun insertOrder(
//        order: Order,
//        onSuccess: () -> Unit,
//        onError: (String) -> Unit
//    ) {
//        orderDao.upsert(order)
//        api.insert(order)
//            .suspendOnSuccess {
//                data.whatIfNotNull {
//                    if (it.success) {
//                        onSuccess()
//                    } else {
//                        onError(it.message)
//                    }
//                }
//            }
//            .suspendOnError {
//                onError(message())
//            }
//            .suspendOnException {
//                onError(message())
//            }
//    }
    suspend fun insert(order: Order,
                       onSuccess: () -> Unit,
                       onError: (String) -> Unit) {
        orderDao.upsert(order)
        orderApi.insert(order)
            .suspendOnSuccess {
                data.whatIfNotNull {
                    if (it.success) {
                        onSuccess()
                    } else {
                        onError(it.message)
                    }
                }
            }
            .suspendOnError {
                onError(message())
            }
            .suspendOnException {
                onError(message())
            }
    }

    suspend fun insertOrderItems(
        orderItems: OrderItem,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        orderItemDao.upsert(orderItems)
        orderItemApi.insert(orderItems)
            .suspendOnSuccess {
                data.whatIfNotNull {
                    if (it.success) {
                        onSuccess()
                    } else {
                        onError(it.message)
                    }
                }
            }
            .suspendOnError {
                onError(message())
            }
            .suspendOnException {
                onError(message())
            }
    }

//    suspend fun updateOrder(
//        order: Order,
//        onSuccess: () -> Unit,
//        onError: (String) -> Unit
//    ) {
//        orderDao.update(order)
//        api.updateOrder(order.id, order)
//            .suspendOnSuccess {
//                data.whatIfNotNull {
//                    if (it.success) {
//                        onSuccess()
//                    } else {
//                        onError(it.message)
//                    }
//                }
//            }
//            .suspendOnError {
//                onError(message())
//            }
//            .suspendOnException {
//                onError(message())
//            }
//    }

    suspend fun deleteOrder(
        orderId: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        orderDao.delete(orderId)
        orderApi.delete(orderId)
            .suspendOnSuccess {
                data.whatIfNotNull {
                    if (it.success) {
                        onSuccess()
                    } else {
                        onError(it.message)
                    }
                }
            }
            .suspendOnError {
                onError(message())
            }
            .suspendOnException {
                onError(message())
            }
    }
}