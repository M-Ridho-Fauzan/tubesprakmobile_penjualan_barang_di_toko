package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.di

import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.RequestInterceptor
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.TodoApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.ItemApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.OrderApi
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient.OrderItemApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://ppm-api.nimbus.biz.id/api/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTodoApi(retrofit: Retrofit): TodoApi {
        return retrofit.create(TodoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideItemApi(retrofit: Retrofit): ItemApi {
        return retrofit.create(ItemApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOrderApi(retrofit: Retrofit): OrderApi {
        return retrofit.create(OrderApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOrderItemApi(retrofit: Retrofit): OrderItemApi {
        return retrofit.create(OrderItemApi::class.java)
    }
}
