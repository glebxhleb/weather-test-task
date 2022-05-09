package com.shuster.testapp.presentation.cities_list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.shuster.testapp.databinding.ItemCityBinding
import com.shuster.testapp.presentation.model.City

class CitiesAdapter(
    private val onCityClick: (City) -> Unit
) : ListAdapter<City, CityHolder>(CityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCityBinding.inflate(layoutInflater, parent, false)
        return CityHolder(binding) { position -> onCityClick(getItem(position)) }
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class CityDiffCallback : DiffUtil.ItemCallback<City>() {

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean =
        oldItem.name == newItem.name

    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean =
        oldItem == newItem
}