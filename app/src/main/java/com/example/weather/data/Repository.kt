package com.example.weather.data

import com.example.weather.data.cloud.Retrofit
import com.example.weather.data.cloud.model.CloudData

class Repository {

    private val api = Retrofit.getApi()

    suspend fun getWeather(city: String): Pair<CloudData, String> {
        return try {
            val result = api.getWeather(city = city).body()
            Pair(result!!, "")
        } catch (e: Exception) {
            Pair(CloudData.Empty(), e.message.toString())
        }
    }

}