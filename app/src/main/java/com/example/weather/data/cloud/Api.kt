package com.example.weather.data.cloud

import com.example.weather.data.cloud.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val KEY = "28d7173f613dc5f489c99e4f62f5109d"

interface Api {

    @Headers("Content-Type: application/json")
    @GET("weather/")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") key: String = KEY,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "ua"
    ): Response<Weather>

}