package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models

import  androidx.room.Entity
import  androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class Todo(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    @SerializedName("due_date")
    val dueDate: String,
)
