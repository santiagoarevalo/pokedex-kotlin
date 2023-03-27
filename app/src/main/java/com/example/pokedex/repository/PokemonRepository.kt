package com.example.pokedex.repository

import com.example.pokedex.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonRepository {

    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") id:String): Call<Pokemon>

}

