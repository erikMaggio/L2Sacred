package com.example.l2sacred.model.repository

import com.example.l2sacred.model.dto.response.ClassGuidesResponse
import com.example.l2sacred.model.service.ApiResponse

interface ClassGuidesRepository {

    suspend fun getClassGuides(connection:Boolean) : ApiResponse<ClassGuidesResponse>

}