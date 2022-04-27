package com.shuster.testapp.presentation.weather_details.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shuster.testapp.databinding.FragmentWeatherDetailsBinding
import com.shuster.testapp.presentation.model.WeatherUiModel
import com.shuster.testapp.presentation.utils.loadImage
import com.shuster.testapp.presentation.utils.repeatWhenStarted
import com.shuster.testapp.presentation.weather_details.viewmodel.WeatherDetailsSate
import com.shuster.testapp.presentation.weather_details.viewmodel.WeatherDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherDetailsFragment : Fragment() {

    private var _binding: FragmentWeatherDetailsBinding? = null

    private val binding: FragmentWeatherDetailsBinding
        get() = _binding!!

    private val viewModel: WeatherDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherDetailsBinding.inflate(inflater, container, false)
        val arguments = WeatherDetailsFragmentArgs.fromBundle(arguments ?: error("no arguments"))
        viewModel.setCity(arguments.cityName)
        viewModel.weatherResult.repeatWhenStarted(viewLifecycleOwner) { data ->
            processResult(data)
        }
        setupToolbar(arguments.cityName)
        return binding.root
    }

    private fun setupToolbar(title: String) {
        with(requireActivity() as AppCompatActivity) {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setTitle(title)
        }
    }

    private fun processResult(data: WeatherDetailsSate) {
        when (data) {
            is WeatherDetailsSate.Success -> showWeather(data.data)
            is WeatherDetailsSate.Loading -> showLoading()
            is WeatherDetailsSate.Error -> showError(data.message)
        }
    }

    private fun showError(message: String) {
        with(binding) {
            groupWeatherDetails.visibility = View.INVISIBLE
            tvError.visibility = View.VISIBLE
            pbLoading.visibility = View.INVISIBLE
            tvError.text = message
        }
    }

    private fun showLoading() {
        with(binding) {
            groupWeatherDetails.visibility = View.INVISIBLE
            tvError.visibility = View.INVISIBLE
            pbLoading.visibility = View.VISIBLE
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showWeather(data: WeatherUiModel) {
        with(binding) {
            groupWeatherDetails.visibility = View.VISIBLE
            tvError.visibility = View.INVISIBLE
            pbLoading.visibility = View.INVISIBLE
            ivPicture.loadImage(data.iconUrl)
            tvHumidityValue.text = "${data.humidity}%"
            tvTemperature.text = "${data.minTemp}° / ${data.maxTemp}°"
            tvWindSpeedValue.text = "${data.windSpeed} m/s, ${data.windDegree}°"
            tvDescription.text = data.description
        }
    }
}