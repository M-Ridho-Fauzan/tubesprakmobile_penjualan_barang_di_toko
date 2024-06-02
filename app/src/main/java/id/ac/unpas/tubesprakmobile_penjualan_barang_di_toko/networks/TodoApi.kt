package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks

import com.skydoves.sandwich.ApiResponse
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.responses.TodoGetResponses
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Body
import retrofit2.http.Path
import retrofit2.http.Headers
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.models.Todo
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.responses.TodoPostResponse
import id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.networks.responses.TodoDeleteResponse

interface TodoApi {
    @GET("todo")
    suspend fun findAll(): ApiResponse<TodoGetResponses>

    @POST("todo")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body todo: Todo): ApiResponse<TodoPostResponse>

    @PUT("todo/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") id: String, @Body todo: Todo): ApiResponse<TodoPostResponse>

    @DELETE("todo/{id}")
    suspend fun delete(@Path("id") id: String): ApiResponse<TodoDeleteResponse>
}
