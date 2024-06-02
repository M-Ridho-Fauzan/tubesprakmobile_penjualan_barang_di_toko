package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.AppDatabase
import javax.inject.Singleton
import android.app.Application
import androidx.room.Room
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.TodoDao


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
}