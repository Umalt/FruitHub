package com.umalt.network

import com.umalt.network.model.response.BaseResponse
import com.umalt.network.model.response.CategoryResponse
import com.umalt.network.model.response.ProductResponse
import retrofit2.http.GET

/**
 * Created by Umalt on 2/22/21
 */
interface ApiService {

    @GET("$API_V1/categories")
    suspend fun getCategories(): BaseResponse<CategoryResponse>

    @GET("$API_V1/products")
    suspend fun getProducts(): BaseResponse<ProductResponse>

    companion object {
        private const val API_V1 = "/api/v1"
    }
}