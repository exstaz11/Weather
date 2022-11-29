package com.example.weather.data.cloud.model

data class Weather(
    val base: String,
    val clouds: Clouds,
    val cod: Float,
    val coord: Coord,
    val dt: Float,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Float,
    val visibility: Float,
    val weather: List<WeatherX>,
    val wind: Wind
): CloudData