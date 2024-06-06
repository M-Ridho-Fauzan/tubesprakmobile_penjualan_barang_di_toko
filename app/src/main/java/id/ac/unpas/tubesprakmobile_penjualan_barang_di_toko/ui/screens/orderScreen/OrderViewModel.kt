package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.orderScreen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.base.LiveCoroutinesViewModel
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.ItemRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : LiveCoroutinesViewModel() {

    private val _isDone: MutableLiveData<Boolean> = MutableLiveData(false)
    val isDone: LiveData<Boolean> = _isDone

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _item: MutableLiveData<Item> = MutableLiveData()
    val item: LiveData<Item> = _item

    private val _isDeleted: MutableLiveData<Boolean> = MutableLiveData(false)
    val isDeleted: LiveData<Boolean> = _isDeleted

    private val _orderItems = mutableStateListOf<OrderItem>()
    val orderItems: List<OrderItem> = _orderItems

//    Load data item
    private val _items: MutableLiveData<Boolean> = MutableLiveData(false)
    val items : LiveData<List<Item>> = _items.switchMap {

        _isLoading.postValue(true)
        launchOnViewModelScope {
            itemRepository.loadItems(
                onSuccess = {
                    _isLoading.postValue(false)
                },
                onError = {
                    _isLoading.postValue(false)
                    Log.e("ItemViewModel", it)
                }
            ).asLiveData()
        }
    }

//    Ambil data item ke back sistem
    fun addToOrder(item: Item) {
    // logika ambil data ke back sistem
    }

    fun removeFromOrder(item: Item) {
    // logika mengeluarkan data dari back sistem
    }
}