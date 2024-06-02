package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.responses

import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Todo

data class TodoPostResponse(
    val message: String,
    val success: Boolean,
    val data: Todo?
)
