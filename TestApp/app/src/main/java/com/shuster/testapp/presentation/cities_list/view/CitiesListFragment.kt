package com.shuster.testapp.presentation.cities_list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.shuster.testapp.databinding.FragmentCitiesListBinding
import com.shuster.testapp.presentation.cities_list.viewmodel.CitiesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitiesListFragment : Fragment() {

    private var _binding: FragmentCitiesListBinding? = null

    private val binding: FragmentCitiesListBinding
        get() = _binding!!

    private val viewModel: CitiesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCitiesListBinding.inflate(inflater, container, false)
        setUpCitiesList()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpCitiesList() {
        with(binding.rvCities) {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    (layoutManager as LinearLayoutManager).orientation
                )
            )
            val citiesAdapter = CitiesAdapter { city ->
                viewModel.onCitySelected(city)
            }
            citiesAdapter.submitList(viewModel.data.cities)
            adapter = citiesAdapter
        }
    }
}
