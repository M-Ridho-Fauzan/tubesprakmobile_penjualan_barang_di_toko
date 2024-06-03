package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Body
import retrofit2.http.Path
import retrofit2.http.Headers
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Item
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.DeleteResponseItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.GetResponsesItem
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.PostResponseItem

interface ItemApi {
    @GET("items")
    suspend fun findAll(): ApiResponse<GetResponsesItem>

    @POST("items")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body item: Item): ApiResponse<PostResponseItem>

    @PUT("items/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") id: String, @Body item: Item): ApiResponse<PostResponseItem>

    @DELETE("items/{id}")
    suspend fun delete(@Path("id") id: String): ApiResponse<DeleteResponseItem>
}
