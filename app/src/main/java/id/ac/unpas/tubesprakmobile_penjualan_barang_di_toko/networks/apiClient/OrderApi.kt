package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient

import com.skydoves.sandwich.ApiResponse
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Order
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.DeleteResponseItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.DeleteResponseOrder
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.GetResponsesItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.GetResponsesOrder
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.PostResponseItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.PostResponseOrder
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface OrderApi {
    @GET("item")
    suspend fun findAll(): ApiResponse<GetResponsesOrder>

    @POST("item")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body order: Order): ApiResponse<PostResponseOrder>

    @PUT("item/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") id: String, @Body order: Order): ApiResponse<PostResponseOrder>

    @DELETE("item/{id}")
    suspend fun delete(@Path("id") id: String): ApiResponse<DeleteResponseOrder>
}
