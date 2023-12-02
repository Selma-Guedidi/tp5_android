package com.example.tp5
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp5.databinding.ActivityWeatherForecastsBinding


class WeatherForecastsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWeatherForecastsBinding
    var forecastViewModel : ForecastViewModel = ForecastViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherForecastsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val city=intent.getStringExtra("city")

        if(city != null){
            forecastViewModel.getForecast(city)
        }

        forecastViewModel.forecast.observe(this) {
            if (it != null){
                binding.forecastsRecycler.adapter = WeatherAdapter(forecastViewModel.forecast.value)
                binding.cityName.text = forecastViewModel.forecast.value!!.city.name
            }
        }

        binding.forecastsRecycler.apply {
            layoutManager = LinearLayoutManager(this@WeatherForecastsActivity)
            adapter = WeatherAdapter(forecastViewModel.forecast.value)
        }
    }
}