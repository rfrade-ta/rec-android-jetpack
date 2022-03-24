package com.viator.android.rec.data.api.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.viator.android.rec.data.api.annotation.PeoplePage

class PeoplePageAdapter {

    @ToJson
    fun toJson(@PeoplePage page: Int?): String? {
        return page?.let { "$PAGE_PREFIX$it" }
    }

    @FromJson
    @PeoplePage
    fun fromJson(page: String): Int? {
        return page.removePrefix(PAGE_PREFIX).toIntOrNull()
    }

    companion object {
        const val PAGE_PREFIX = "https://swapi.dev/api/people/?page="
    }
}
