package com.viator.android.rec.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.viator.android.rec.data.api.adapter.PeoplePageAdapter
import com.viator.android.rec.data.model.PeopleList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsService {

    @GET("people")
    suspend fun getPeopleList(@Query("page") page: Int?): Response<PeopleList>

    companion object {
        private const val BASE_URL = "https://swapi.dev/api/"

        fun create(): StarWarsService {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(PeoplePageAdapter())
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(StarWarsService::class.java)
        }
    }
}
