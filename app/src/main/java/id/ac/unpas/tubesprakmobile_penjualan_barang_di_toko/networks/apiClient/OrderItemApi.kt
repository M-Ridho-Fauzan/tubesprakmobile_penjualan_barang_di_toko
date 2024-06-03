package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Body
import retrofit2.http.Path
import retrofit2.http.Headers
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.OrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.DeleteResponseOrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.GetResponsesOrderItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.PostResponseOrderItem

interface OrderItemApi {
    @GET("order_items")
    suspend fun findAll(): ApiResponse<GetResponsesOrderItem>

    @POST("order_items")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body orderItem: OrderItem): ApiResponse<PostResponseOrderItem>

    @PUT("order_items/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") id: String, @Body orderItem: OrderItem): ApiResponse<PostResponseOrderItem>

    @DELETE("order_items/{id}")
    suspend fun delete(@Path("id") id: String): ApiResponse<DeleteResponseOrderItem>
}
