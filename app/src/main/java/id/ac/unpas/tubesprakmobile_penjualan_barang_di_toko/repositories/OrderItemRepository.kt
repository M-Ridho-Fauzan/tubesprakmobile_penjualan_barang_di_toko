package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories

import androidx.annotation.WorkerThread
import com.skydoves.sandwich.message
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.OrderItemApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.OrderItemDao
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OrderItemRepository @Inject constructor(private val api: OrderItemApi, private val dao: OrderItemDao) {

    @WorkerThread
    fun loadOrderItems(onSuccess: () -> Unit,
                       onError: (String) -> Unit) = flow {
        val list: List<OrderItem> = dao.findAll()
        api.findAll()
            .suspendOnSuccess {
                data.whatIfNotNull {
                    dao.upsert(it.orderItems)
                    val localList = dao.findAll()
                    emit(localList)
                    onSuccess()
                }
            }
            .suspendOnError {
                emit(list)
                onError(message())
            }
            .suspendOnException {
                emit(list)
                onError(message())
            }
    }

    suspend fun insert(orderItem: OrderItem,
                       onSuccess: () -> Unit,
                       onError: (String) -> Unit) {
        dao.upsert(orderItem)
        api.insert(orderItem)
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

    suspend fun update(orderItem: OrderItem,
                       onSuccess: () -> Unit,
                       onError: (String) -> Unit) {
        dao.upsert(orderItem)
        api.update(orderItem.id, orderItem)
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

    suspend fun delete(id: String,
                       onSuccess: () -> Unit,
                       onError: (String) -> Unit) {
        dao.delete(id)
        api.delete(id)
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

    suspend fun find(id: String) = dao.find(id)
}
