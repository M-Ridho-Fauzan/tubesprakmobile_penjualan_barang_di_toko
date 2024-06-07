package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao

import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item


// ItemDao.kt
@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun loadAll(): LiveData<List<Item>>

    @Query("SELECT * FROM item")
    suspend fun findAll(): List<Item>

    @Query("SELECT * FROM item WHERE id = :id")
    fun load(id: String): LiveData<Item>

    @Query("SELECT * FROM item WHERE id = :id")
    suspend fun getById(id: String): Item?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(vararg items: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(list: List<Item>)

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT * FROM item WHERE id = :id")
    suspend fun find(id: String): Item?

    @Delete
    suspend fun delete(item: Item)

    @Update
    suspend fun updateOrInsert(
//        @PrimaryKey
        id: String,
//        @ColumnInfo("name")
        name: String?,
//        @ColumnInfo("description")
        description: String?,
//        @ColumnInfo("price")
        price: Float?,
//        @ColumnInfo("stock")
        stock: Int?
    ): Item {
        return Item(
            id = id,
            name = name ?: this.getById(id)?.name ?: "",
            description = description ?: this.getById(id)?.description ?: "",
            price = price ?: this.getById(id)?.price ?: 0f,
            stock = stock ?: this.getById(id)?.stock ?: 0
        ).also {
            this.upsert(it)
        }
    }
}