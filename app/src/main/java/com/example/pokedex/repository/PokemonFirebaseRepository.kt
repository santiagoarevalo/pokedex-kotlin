package com.example.pokedex.repository

import com.example.pokedex.model.Pokemon
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

interface PokemonFirebaseRepository {

    @PUT("pokemons/{id}.json")
    fun postPokemon(@Path("id") id:String, @Body pokemon: Pokemon) : Call<Pokemon>
    abstract fun getPokemons(): Call<HashMap<String, Pokemon>>

}