package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Order
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Todo
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.ItemDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.OrderDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.OrderItemDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.TodoDao

@Database(entities =
[Todo::class, Order::class, OrderItem::class, Item::class]
    , version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun todoDao(): TodoDao
    abstract fun itemDao(): ItemDao
    abstract fun orderDao(): OrderDao
    abstract fun orderItemDao(): OrderItemDao

    companion object {
        const val DATABASE_NAME = "toko_database"
    }
}