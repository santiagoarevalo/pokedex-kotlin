package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
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

        viewModel.getDetails("100")
        viewModel.pokemon.observe(this) {
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }
    }
}