package com.example.l2sacred.model.datasource

import com.example.l2sacred.model.dto.response.ClassGuidesResponse
import com.example.l2sacred.model.service.ApiResponse
import com.example.l2sacred.model.service.content.ClassGuidesServiceImp
import com.example.l2sacred.utils.Constants

class ClassGuidesDataSource(private val classGuidesServiceImp: ClassGuidesServiceImp = ClassGuidesServiceImp()) {

    suspend fun getClassGuides(connection: Boolean): ApiResponse<ClassGuidesResponse> {
        return if (connection) {
            classGuidesServiceImp.getClassGuides()
        } else {
            throw Exception(Constants.ERROR_CONNECTION)
        }
    }
}
