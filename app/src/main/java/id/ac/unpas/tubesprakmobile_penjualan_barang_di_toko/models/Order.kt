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

//"id": "30be2ef3-b43d-4ba8-b1e9-5f40378a1714",
//"order_date": "2024-05-26",
//"total_price": 20000,
//"payment_method": "cash", //cash, credit card, debit card, transfer, e-wallet
//"remarks": "paid"