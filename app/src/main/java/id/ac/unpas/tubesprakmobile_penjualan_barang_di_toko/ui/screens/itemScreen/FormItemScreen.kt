package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.itemScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.benasher44.uuid.uuid4
import kotlinx.coroutines.launch

@Composable
fun FormItemScreen(modifier: Modifier = Modifier, id: String? = null) {

    val viewModel = hiltViewModel<ItemViewModel>()
    val scope = rememberCoroutineScope()

    val name = remember { mutableStateOf(TextFieldValue("")) }
    val description = remember { mutableStateOf(TextFieldValue("")) }
    val price = remember { mutableFloatStateOf(0f) }
    val stock = remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                label = { Text(text = "Name") },
                modifier = Modifier.fillMaxWidth(),
                value = name.value,
                onValueChange = { name.value = it }
            )

            OutlinedTextField(
                label = { Text(text = "Description") },
                modifier = Modifier.fillMaxWidth(),
                value = description.value,
                onValueChange = { description.value = it }
            )

            OutlinedTextField(
                label = { Text(text = "Price") },
                modifier = Modifier.fillMaxWidth(),
                value = price.value.toString(),
                onValueChange = { newValue ->
                    if (newValue.isNotBlank()) {
                        val parsedValue = newValue.toFloatOrNull()
                        if (parsedValue != null) {
                            price.value = parsedValue
                        }
                    } else {
                        price.value = 0f
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )

            OutlinedTextField(
                label = { Text(text = "Stock") },
                modifier = Modifier.fillMaxWidth(),
                value = stock.value.toString(),
                onValueChange = { newValue ->
                    if (newValue.isNotBlank()) {
                        val parsedValue = newValue.toIntOrNull()
                        if (parsedValue != null) {
                            stock.value = parsedValue
                        }
                    } else {
                        stock.value = 0
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Row {
                Button(
                    modifier = Modifier.weight(5f),
                    onClick = {
//                        Untuk Fungsi edit
                        if (id != null) {
                            scope.launch {
                                viewModel.update(
                                    id,
                                    name.value.text,
                                    description.value.text,
                                    price.value,
                                    stock.value
                                )
                            }
                        } else {
//                            Untuk fungsi create
                            scope.launch {
                                viewModel.insert(
                                    uuid4().toString(),
                                    name.value.text,
                                    description.value.text,
                                    price.value,
                                    stock.value
                                )
                            }
                        }
                    }
                ) {
                    Text(text = "Simpan")
                }

                Button(
                    modifier = Modifier.weight(5f),
                    onClick = {
                        name.value = TextFieldValue("")
                        description.value = TextFieldValue("")
                        price.value = 0f
                        stock.value = 0
                    }
                ) {
                    Text(text = "Batal")
                }
            }
        }

        viewModel.isDone.observe(LocalLifecycleOwner.current) {
            if (it) {
                name.value = TextFieldValue("")
                description.value = TextFieldValue("")
                price.value = 0f
                stock.value = 0
            }
        }

        LaunchedEffect(id) {
            if (id != null) {
                scope.launch {
                    viewModel.find(id)
                }
            }
        }

        viewModel.item.observe(LocalLifecycleOwner.current) {
            name.value = TextFieldValue(it.name)
            description.value = TextFieldValue(it.description)
            price.value = it.price
            stock.value = it.stock
        }
    }
}