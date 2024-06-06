package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.itemScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import dagger.hilt.android.lifecycle.HiltViewModel
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.base.LiveCoroutinesViewModel
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.ItemRepository
import javax.inject.Inject

@HiltViewModel
class  ItemViewModel @Inject constructor(private val itemRepository: ItemRepository)
    : LiveCoroutinesViewModel() {

    private val _isDone: MutableLiveData<Boolean> = MutableLiveData(false)
    val isDone: LiveData<Boolean> = _isDone

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _item: MutableLiveData<Item> = MutableLiveData()
    val item: LiveData<Item> = _item

    private val _isDeleted: MutableLiveData<Boolean> = MutableLiveData(false)
    val isDeleted: LiveData<Boolean> = _isDeleted

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

    suspend fun insert(id: String,
                       name: String,
                       description: String,
                       price: Float,
                       stock: Int) {
        _isLoading.postValue(true)
        itemRepository.insert(Item(id, name, description, price, stock),
            onSuccess = {
                _isLoading.postValue(false)
                _isDone.postValue(true)
                _items.postValue(true)
            },
            onError = {
                _isLoading.postValue(false)
                _isDone.postValue(true)
                _items.postValue(true)
            }
        )
    }

    suspend fun update(id: String,
                       name: String,
                       description: String,
                       price: Float,
                       stock: Int) {
        _isLoading.postValue(true)
        itemRepository.insert(Item(id, name, description, price, stock),
            onSuccess = {
                _isLoading.postValue(false)
                _isDone.postValue(true)
                _items.postValue(true)
            },
            onError = {
                _isLoading.postValue(false)
                _isDone.postValue(true)
                _items.postValue(true)
            }
        )
    }

    suspend fun delete(id: String) {
        _isLoading.postValue(true)
        itemRepository.delete(id,
            onSuccess = {
                _isLoading.postValue(false)
                _isDone.postValue(true)
                _items.postValue(true)
                _isDeleted.postValue(true)
            },
            onError = {
                _isLoading.postValue(false)
                _isDone.postValue(true)
                _items.postValue(true)
                _isDeleted.postValue(false)
            }
        )
    }

    suspend fun find(id: String) {
        val item = itemRepository.find(id)
        item?.let {
            _item.postValue(it)
        }
    }
}