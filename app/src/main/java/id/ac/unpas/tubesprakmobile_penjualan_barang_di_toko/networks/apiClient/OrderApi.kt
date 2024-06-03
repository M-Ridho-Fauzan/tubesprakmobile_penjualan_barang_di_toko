package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Body
import retrofit2.http.Path
import retrofit2.http.Headers
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Order
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.DeleteResponseOrder
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.GetResponsesOrder
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.PostResponseOrder

interface OrderApi {
    @GET("orders")
    suspend fun findAll(): ApiResponse<GetResponsesOrder>

    @POST("orders")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body order: Order): ApiResponse<PostResponseOrder>

    @PUT("orders/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") id: String, @Body order: Order): ApiResponse<PostResponseOrder>

    @DELETE("orders/{id}")
    suspend fun delete(@Path("id") id: String): ApiResponse<DeleteResponseOrder>
}
