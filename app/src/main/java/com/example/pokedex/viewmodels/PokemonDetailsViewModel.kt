package com.example.pokedex.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.model.Pokemon
import com.example.pokedex.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonDetailsViewModel : ViewModel() {

    //Variables to be displayed in the view
    val pokemon: MutableLiveData<Pokemon> = MutableLiveData()

    //Function to be called from the view
    fun getDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            //Retrofit call to get the pokemon details
            val result = RetrofitClient.pokeAPIService.getPokemonById(id).execute().body()
            withContext(Dispatchers.Main) {
                result?.let {
                    pokemon.value = it
                }
            }
        }
    }

}

