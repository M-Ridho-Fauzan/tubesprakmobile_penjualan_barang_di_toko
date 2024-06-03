package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.AppDatabase
import javax.inject.Singleton
import android.app.Application
import androidx.room.Room
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.ItemDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.OrderDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.OrderItemDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.TodoDao

//Class ini menginjeksi object2 yang di butuhkan, dan di wakili oleh fungsi2

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application) : AppDatabase{
        return Room.databaseBuilder(application, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(appDatabase: AppDatabase) : TodoDao {
        return appDatabase.todoDao()
    }

    @Provides
    @Singleton
    fun provideItemDao(appDatabase: AppDatabase) : ItemDao {
        return appDatabase.itemDao()
    }

    @Provides
    @Singleton
    fun provideOrderDao(appDatabase: AppDatabase) : OrderDao {
        return appDatabase.orderDao()
    }

    @Provides
    @Singleton
    fun provideOrderItemDao(appDatabase: AppDatabase) : OrderItemDao {
        return appDatabase.orderItemDao()
    }
}