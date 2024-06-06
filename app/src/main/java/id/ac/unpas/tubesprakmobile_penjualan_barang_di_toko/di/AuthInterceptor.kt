package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.di

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        // Tambahkan header atau token otorisasi yang diperlukan di sini
        requestBuilder.addHeader("Authorization", "Bearer $token")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}