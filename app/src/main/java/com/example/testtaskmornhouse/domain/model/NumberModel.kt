package com.example.testtaskmornhouse.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NumberModel(
    val number: String,
    val text: String,
) : Parcelable