package com.example.l2sacred.model.repository

import com.example.l2sacred.model.datasource.ClassGuidesDataSource
import com.example.l2sacred.model.dto.response.ClassGuidesResponse
import com.example.l2sacred.model.service.ApiResponse

class ClassGuidesRepositoryImp(private val classGuidesDataSource: ClassGuidesDataSource = ClassGuidesDataSource()) :
    ClassGuidesRepository {

    override suspend fun getClassGuides(connection: Boolean) =
        classGuidesDataSource.getClassGuides(connection)
}
