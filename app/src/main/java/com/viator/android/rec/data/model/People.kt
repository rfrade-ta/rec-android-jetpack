package com.viator.android.rec.data.model

import com.squareup.moshi.Json

data class People(
    val name: String,
    val height: String,
    val mass: String,
    val gender: String,
    @Json(name = "birth_year") val birthYear: String
)
