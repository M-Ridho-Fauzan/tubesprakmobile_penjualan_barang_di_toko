package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.itemScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.composables.ConfirmationDialog
//import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.TodoItem
import kotlinx.coroutines.launch

@Composable
fun ListItemScreen(
    modifier: Modifier = Modifier,
    onDelete: () -> Unit,
    onClick: (String) -> Unit
)
{

    val scope = rememberCoroutineScope()
    val viewModel = hiltViewModel<ItemViewModel>()

    val list: List<Item> by viewModel.items.observeAsState(listOf())
    val title = remember { mutableStateOf("List Items") }

    val openDialog = remember {
        mutableStateOf(false)
    }
    val activeId = remember {
        mutableStateOf("")
    }
    val deleting = remember {
        mutableStateOf(false)
    }
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = title.value, modifier = Modifier.fillMaxWidth())
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(list.size) { index ->
                val items = list[index]
                ItemRow(
                    item = items,
                    onEditClick = { id ->
                        onClick(id)
                    },
                    onDeleteClick = { id ->
                        deleting.value = true
                        activeId.value = id
                        openDialog.value = true
                    },
                    onAddChartClick = {}, // Karena tidak diperlukan pada screen ini
                    showEditDeleteButtons = true
                )
            }
        }
    }

    if (openDialog.value) {
        ConfirmationDialog(onDismiss = {
            openDialog.value = false
        }) {
            scope.launch {
                viewModel.delete(activeId.value)
            }
            openDialog.value = false
        }
    }

    viewModel.isLoading.observe(LocalLifecycleOwner.current) {
        if (it) {
            title.value = "Loading..."
        } else {
            title.value = "TODO"
        }
    }

    viewModel.isDeleted.observe(LocalLifecycleOwner.current) {
        if (deleting.value && it) {
            deleting.value = false
            onDelete()
        }
    }
}