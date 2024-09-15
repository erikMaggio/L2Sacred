package com.example.l2sacred.model.dto.response

data class ClassGuidesResponse(
    val data: Data
) {
    data class Data(
        val races: List<Races>
    )

    data class Races(
        val name: String,
        val categories: List<Categories>
    )

    data class Categories(
        val type: String,
        val professions: List<Professions>
    )

    data class Professions(
        val secondProfession: String,
        val thirdProfession: String
    )
}
