package com.example.pokedex.retrofit

import com.example.pokedex.repository.PokemonRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val pokeAPI = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val pokeAPIService: PokemonRepository = pokeAPI.create(PokemonRepository::class.java)
}