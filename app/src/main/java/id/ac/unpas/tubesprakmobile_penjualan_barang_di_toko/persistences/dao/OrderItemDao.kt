package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem

@Dao
interface OrderItemDao {

    @Query("select * from 'order_item'")
    fun loadAll(): LiveData<List<OrderItem>>

    @Query("select * from 'order_item'")
    suspend fun findAll(): List<OrderItem>

    @Query("select * from 'order_item' where id = :id")
    fun load(id: String): LiveData<OrderItem>

    @Query("select * from 'order_item' where id = :id")
    suspend fun getById(id: String): OrderItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(vararg items: OrderItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(list: List<OrderItem>)

    @Query("delete from 'order_item' where id = :id")
    suspend fun delete(id: String)

    @Query("select * from 'order_item' where id = :id")
    suspend fun find(id: String): OrderItem?

    @Delete
    suspend fun delete(item: OrderItem)
}