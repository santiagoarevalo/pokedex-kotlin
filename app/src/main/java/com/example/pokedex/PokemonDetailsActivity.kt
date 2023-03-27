package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.databinding.ActivityPokemonDetailsBinding
import com.example.pokedex.viewmodels.PokemonDetailsViewModel

class PokemonDetailsActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityPokemonDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel: PokemonDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var goal = intent.extras?.getString("goal")
        goal?.let {
            viewModel.getDetails("150")
            viewModel.pokemon.observe(this) {pokemon ->
                binding.pokemonName.text = pokemon.name
                binding.defenseTV.text = pokemon.stats[2].base_stat.toString()
                binding.attackTV.text = pokemon.stats[1].base_stat.toString()
                binding.lifeTV.text = pokemon.stats[0].base_stat.toString()
                binding.speedTV.text = pokemon.stats[5].base_stat.toString()
                Glide.with(this).load(pokemon.sprites.front_default).into(binding.pokeimg)
            }
        } ?: run {
            Toast.makeText(this, "No se ha encontrado el pokemon", Toast.LENGTH_SHORT).show()
        }
    }
}