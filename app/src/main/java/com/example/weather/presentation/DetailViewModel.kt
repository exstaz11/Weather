package com.example.weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.Repository
import com.example.weather.data.cloud.model.CloudData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel : ViewModel() {

    private val repository = Repository()

    fun getWeather(city: String, onResultBlock: (Pair<CloudData, String>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getWeather(city)
            withContext(Dispatchers.Main) {
                onResultBlock.invoke(result)
            }
        }
    }

}