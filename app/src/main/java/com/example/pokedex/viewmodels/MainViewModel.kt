package com.example.pokedex.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.model.Pokemon
import com.example.pokedex.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    val pokemons = arrayListOf<Pokemon>()
    val pokemonsLiveData = MutableLiveData<List<Pokemon>>() //LiveData is a wrapper around the data that we want to observe

    fun getPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            var pokemonMan = RetrofitClient.realtimeDBAPIService.getPokemons()
                .execute()
                .body()

            pokemonMan?.let {
                pokemons.addAll(it.values.toList())
                //var pokemonsList = it.values.toList()
                withContext(Dispatchers.Main) {
                    pokemonsLiveData.value = pokemons
                }
            }
        }
    }
}