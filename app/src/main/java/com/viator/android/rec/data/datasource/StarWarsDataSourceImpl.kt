package com.viator.android.rec.data.datasource

import com.viator.android.rec.data.api.StarWarsService
import com.viator.android.rec.data.model.PeopleList

internal class StarWarsDataSourceImpl(
    private val starWarsService: StarWarsService
) : StarWarsDataSource {

    override suspend fun getPeopleList(page: Int?): Result<PeopleList> {
        val response = starWarsService.getPeopleList(page)
        return if (response.isSuccessful) {
            response.body()?.let { Result.success(it) }
                ?: Result.failure(RuntimeException("Error fetching people list"))
        } else {
            Result.failure(RuntimeException("Error fetching people list"))
        }
    }
}
