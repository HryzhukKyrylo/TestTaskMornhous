package com.example.testtaskmornhouse.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NumberModel(
    val number: Int,
    val text: String,
) : Parcelable