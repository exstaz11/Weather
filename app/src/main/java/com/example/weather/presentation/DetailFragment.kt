package com.example.weather.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.weather.data.cloud.model.Weather
import com.example.weather.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[DetailViewModel::class.java]

        val args: DetailFragmentArgs by navArgs()
        val city = args.city

        viewModel.getWeather(city) {
            binding.progressBar.visibility = View.GONE
            val weather = it.first
            val errorMessage = it.second
            if (weather is Weather) {
                val main = weather.main
                binding.weatherTv.text =
                    "Температура повітря: ${main.temp} C\nВідчувається: ${main.feels_like} C\nШвідкість вітру: ${weather.wind.speed} m/s\nАтмосфернний тиск: ${main.pressure} hpa"
            } else {
                binding.errorTv.visibility = View.VISIBLE
                binding.errorTv.text = errorMessage
            }
        }
    }

}