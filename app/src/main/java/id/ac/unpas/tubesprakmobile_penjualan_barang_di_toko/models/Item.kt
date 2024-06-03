package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models

import  androidx.room.Entity
import  androidx.room.PrimaryKey
import javax.annotation.concurrent.Immutable

@Entity(tableName = "item")
@Immutable
data class Item(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val price: Float,
    val stock: Int,
)