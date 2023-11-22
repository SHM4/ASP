package com.example.a231121buildgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val whatNumber: Int,
    @DrawableRes val imageResourceId: Int
)