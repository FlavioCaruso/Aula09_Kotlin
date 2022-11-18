package com.example.aula_09.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aula_09.model.Country

class ListViewModel : ViewModel() {

    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true
        val dummyData = generateDummyCountries()
        countries.value = dummyData
        countryLoadError.value = ""
        loading.value = false
    }

    private fun generateDummyCountries(): List<Country>? {
        val countries = arrayListOf<Country>()
        countries.add(Country("dummyCountry1", "dummyCapital1", ""))
        countries.add(Country("dummyCountry2", "dummyCapital2", ""))
        countries.add(Country("dummyCountry3", "dummyCapital3", ""))
        countries.add(Country("dummyCountry4", "dummyCapital4", ""))
        countries.add(Country("dummyCountry5", "dummyCapital5", ""))
        countries.add(Country("dummyCountry6", "dummyCapital6", ""))
        return countries
    }

    private fun onError(message: String) {
        countryLoadError.value = message
        loading.value = false
    }

}