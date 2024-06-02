package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ConfirmationDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text(text = "Konfirmasi")
        },
        text = {
            Text(text = "Apakah anda yakin ingin menghapus data ini?")
        },
        confirmButton = {
            Button(onClick = {
                onConfirm()
            }) {
                Text(text = "Ya")
            }
        },
        dismissButton = {
            Button(onClick = {
                onDismiss()
            }) {
                Text(text = "Tidak")
            }
        }
    )
}
