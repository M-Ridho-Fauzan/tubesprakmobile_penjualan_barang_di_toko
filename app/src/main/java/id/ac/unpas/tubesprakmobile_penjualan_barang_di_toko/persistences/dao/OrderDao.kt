package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Order

@Dao
interface OrderDao {

    @Query("select * from 'order'")
    fun loadAll(): LiveData<List<Order>>

    @Query("select * from 'order'")
    suspend fun findAll(): List<Order>

    @Query("select * from 'order' where id = :id")
    fun load(id: String): LiveData<Order>

    @Query("select * from 'order' where id = :id")
    suspend fun getById(id: String): Order?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(vararg items: Order)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(list: List<Order>)

    @Query("delete from 'order' where id = :id")
    suspend fun delete(id: String)

    @Query("select * from 'order' where id = :id")
    suspend fun find(id: String): Order?

    @Delete
    suspend fun delete(item: Order)
}