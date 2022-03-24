package com.viator.android.rec.data.datasource

import com.viator.android.rec.data.model.PeopleList

interface StarWarsDataSource {
    suspend fun getPeopleList(page: Int?): Result<PeopleList>
}
