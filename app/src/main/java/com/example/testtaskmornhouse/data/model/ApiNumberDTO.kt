package com.example.testtaskmornhouse.data.model

import com.example.testtaskmornhouse.domain.model.NumberModel

data class ApiNumberDTO(
    val found: Boolean,
    val number: Int,
    val text: String,
    val type: String
)

fun ApiNumberDTO.toModel(): NumberModel {
    return NumberModel(
        number = this.number,
        text = this.text,
    )
}