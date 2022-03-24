package com.viator.android.rec.data.model

import com.viator.android.rec.data.api.annotation.PeoplePage

data class PeopleList(
    val count: Int,
    @PeoplePage val next: Int?,
    @PeoplePage val previous: Int?,
    val results: List<People>,
)
