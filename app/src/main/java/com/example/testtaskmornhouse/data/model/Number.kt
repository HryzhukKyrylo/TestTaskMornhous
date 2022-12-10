package com.example.testtaskmornhouse.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtaskmornhouse.domain.model.NumberModel

@Entity(tableName = "my_number_table")
data class Number(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val number: String,
    val text: String,
)

fun NumberModel.toEntity(): Number {
    return Number(
        number = this.number,
        text = this.text,
    )
}

fun Number.toEntity(): NumberModel {
    return NumberModel(
        number = this.number,
        text = this.text,
    )
}