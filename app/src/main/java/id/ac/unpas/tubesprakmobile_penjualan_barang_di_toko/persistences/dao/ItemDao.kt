package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item

@Dao
interface ItemDao {

    @Query("select * from item")
    fun loadAll(): LiveData<List<Item>>

    @Query("select * from item")
    suspend fun findAll(): List<Item>

    @Query("select * from item where id = :id")
    fun load(id: String): LiveData<Item>

    @Query("select * from item where id = :id")
    suspend fun getById(id: String): Item?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(vararg items: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(list: List<Item>)

    @Query("delete from item where id = :id")
    suspend fun delete(id: String)

    @Query("select * from item where id = :id")
    suspend fun find(id: String): Item?
// Todo
    @Delete
    suspend fun delete(item: Item)
}