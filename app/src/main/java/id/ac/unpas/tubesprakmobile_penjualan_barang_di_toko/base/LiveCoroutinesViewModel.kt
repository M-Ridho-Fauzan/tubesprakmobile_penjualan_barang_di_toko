package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

// Ini adalah base class dari view model ke TodoViewModel

abstract class LiveCoroutinesViewModel : ViewModel() {

    inline fun<T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
        return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(block())
        }
    }
}