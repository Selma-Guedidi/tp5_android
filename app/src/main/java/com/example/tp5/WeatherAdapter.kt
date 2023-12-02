package com.example.tp5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp5.databinding.WeatherItemBinding
import com.example.tp5.forecast_models.ForecastResponse
import java.util.Date


class WeatherAdapter(private val forecast: ForecastResponse?) :
RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(val binding: WeatherItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = WeatherItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.pressure.text = "Pressure ${forecast?.list?.get(position)?.pressure.toString()}: "
        holder.binding.temperature.text = "Temperature ${forecast?.list?.get(position)?.temp?.day.toString()}: "
        holder.binding.humidity.text = "Humidity ${forecast?.list?.get(position)?.humidity.toString()}: "
        holder.binding.day.text = "Date ${Date(forecast?.list?.get(position)?.dt.toString().toLong()*1000)}: "
    }

    override fun getItemCount(): Int {
        return forecast?.list?.size ?: 0
    }
}