package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.TodoApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.TodoDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.TodoRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideTodoRepository(
        todoDao: TodoDao,
        todoApi: TodoApi
    ): TodoRepository {
        return TodoRepository(todoApi, todoDao)
    }
}