//package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.di
//
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ViewModelComponent
//import dagger.hilt.android.scopes.ViewModelScoped
//import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.TodoApi
//import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.TodoDao
//import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.TodoRepository
//
//@Module
//@InstallIn(ViewModelComponent::class)
//object RepositoryModule {
//
//    @Provides
//    @ViewModelScoped
//    fun provideTodoRepository(
//        todoDao: TodoDao,
//        todoApi: TodoApi
//    ): TodoRepository {
//        return TodoRepository(todoApi, todoDao)
//    }
//}

package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.TodoApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.ItemApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.OrderApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.OrderItemApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.TodoDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.ItemDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.OrderDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.persistences.dao.OrderItemDao
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.TodoRepository
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.ItemRepository
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.OrderRepository
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.repositories.OrderItemRepository

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

    @Provides
    @ViewModelScoped
    fun provideItemRepository(
        itemDao: ItemDao,
        itemApi: ItemApi
    ): ItemRepository {
        return ItemRepository(itemApi, itemDao)
    }

    @Provides
    @ViewModelScoped
    fun provideOrderRepository(
        orderApi: OrderApi,
        orderItemApi: OrderItemApi,
        orderDao: OrderDao,
        orderItemDao: OrderItemDao
    ): OrderRepository {
        return OrderRepository(orderApi, orderItemApi, orderDao, orderItemDao)
    }

    @Provides
    @ViewModelScoped
    fun provideOrderItemRepository(
        orderItemDao: OrderItemDao,
        orderItemApi: OrderItemApi
    ): OrderItemRepository {
        return OrderItemRepository(orderItemApi, orderItemDao)
    }
}
