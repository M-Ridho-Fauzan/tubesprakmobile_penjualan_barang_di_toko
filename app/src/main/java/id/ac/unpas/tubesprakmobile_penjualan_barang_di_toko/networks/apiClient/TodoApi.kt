package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.apiClient

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Body
import retrofit2.http.Path
import retrofit2.http.Headers
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Todo
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.GetResponsesTodo
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.DeleteResponseTodo
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.PostResponseTodo
//import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.responses.ResponseModels

interface TodoApi {
    @GET("todo")
    suspend fun findAll(): ApiResponse<GetResponsesTodo>

    @POST("todo")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body todo: Todo): ApiResponse<PostResponseTodo>

    @PUT("todo/{id}")// Edit
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") id: String, @Body todo: Todo): ApiResponse<PostResponseTodo>

    @DELETE("todo/{id}")
    suspend fun delete(@Path("id") id: String): ApiResponse<DeleteResponseTodo>
}
