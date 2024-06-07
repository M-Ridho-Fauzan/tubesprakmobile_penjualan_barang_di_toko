package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens.itemScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.R
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item

@Composable
fun ItemRow(
    item: Item,
    onEditClick: (String) -> Unit = {},
    onDeleteClick: (String) -> Unit = {},
    onAddChartClick: (String) -> Unit = {},
    showEditDeleteButtons: Boolean = true,
) {
    Row {
        Text(modifier = Modifier.weight(2f), text = item.name)
        Text(modifier = Modifier.weight(3f), text = item.description)
        Text(modifier = Modifier.weight(1f), text = item.price.toString())
        Text(modifier = Modifier.weight(1f), text = item.stock.toString())

        if (showEditDeleteButtons == true) {
            Icon(
                painterResource(id = R.drawable.baseline_edit_24),
                "Edit",
                modifier = Modifier
                    .weight(1f)
                    .clickable { onEditClick(item.id) }
            )
            Icon(
                painterResource(id = R.drawable.baseline_delete_24),
                "Delete",
                modifier = Modifier
                    .weight(1f)
                    .clickable { onDeleteClick(item.id) }
            )
        } else {
//            if (isSelected){
                Icon(
                    painterResource(id = R.drawable.baseline_checkout_24), // Ganti dengan ikon yang sesuai
                    "Add Chart",
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            onAddChartClick(item.id)
                        }
                )

        }
    }
}