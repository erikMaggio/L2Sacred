package com.example.l2sacred.model.service.content

import com.example.l2sacred.model.dto.response.ClassGuidesResponse
import com.example.l2sacred.model.service.ApiResponse
import com.example.l2sacred.model.service.RetrofitClient
import com.example.l2sacred.utils.Constants
import retrofit2.Response
import java.io.IOException

class ClassGuidesServiceImp {

    private val getInstance = RetrofitClient.getInstanceClass()

    suspend fun getClassGuides(): ApiResponse<ClassGuidesResponse> {
        return makeApiCall { getInstance.getClassGuides() }
    }
    private suspend fun <T> makeApiCall(call: suspend () -> Response<T>): ApiResponse<T> {
        return try {
            val response = call()
            ApiResponse.create(response.code(), response.body(), response.message())
        } catch (e: IOException) {
            ApiResponse.create(Constants.TIME_OUT, null, "Timeout")
        } catch (e: Exception) {
            ApiResponse.create(Constants.CODE_GENERIC, null, "Error genérico")
        }
    }
}
