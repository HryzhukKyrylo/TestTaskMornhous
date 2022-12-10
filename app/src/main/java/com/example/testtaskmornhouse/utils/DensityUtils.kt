package com.example.testtaskmornhouse.utils

import android.content.res.Resources

val Int.dp: Float
    get() = Resources.getSystem().displayMetrics.density * this