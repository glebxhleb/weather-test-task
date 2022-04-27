package com.shuster.testapp.presentation.cities_list.view

import androidx.recyclerview.widget.RecyclerView
import com.shuster.testapp.databinding.ItemCityBinding
import com.shuster.testapp.presentation.model.City

class CityHolder(
    private val binding: ItemCityBinding,
    private val onCityClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            onCityClick(adapterPosition)
        }
    }

    fun bind(city: City) {
        binding.tvCityName.text = city.name
    }
}