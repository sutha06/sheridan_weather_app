package ca.suthakaran.weather.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ReposApi {
    @GET("weather") // Endpoint relative to the base URL
    suspend fun getRepos(
        @Query("q") location: String,

        @Query("appid") apiKey: String,

        @Query("units") units: String
    ): ApiData
}

