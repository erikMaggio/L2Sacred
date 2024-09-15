package com.example.l2sacred.model.service.content

import com.example.l2sacred.model.dto.response.ClassGuidesResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {

    @GET("/guide_class")
    suspend fun getClassGuides(): Response<ClassGuidesResponse>
}
