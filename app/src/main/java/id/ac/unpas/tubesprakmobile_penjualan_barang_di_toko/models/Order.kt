package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models

import  androidx.room.Entity
import  androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import javax.annotation.concurrent.Immutable

@Entity(tableName = "order")
@Immutable
data class Order(
    @PrimaryKey
    val id: String,
    @SerializedName("order_date")
    val orderDate: String,
    @SerializedName("total_price")
    val totalPrice: String,
    @SerializedName("payment_method")
    val paymentMethod: String,//cash, credit card, debit card, transfer, e-wallet
    val remarks: String,
)