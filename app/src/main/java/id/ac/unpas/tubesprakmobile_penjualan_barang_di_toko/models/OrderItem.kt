package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models

import  androidx.room.Entity
import  androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import javax.annotation.concurrent.Immutable

@Entity(tableName = "order_item")
@Immutable
data class OrderItem(
    @PrimaryKey
    val id: String,
    @SerializedName("shop_order_id")
    val shopOrderId: String,
    @SerializedName("shop_item_id")
    val shopItemId: String,
    @SerializedName("unit_price")
    val unitPrice: String,
    val quantity: Int,
)
