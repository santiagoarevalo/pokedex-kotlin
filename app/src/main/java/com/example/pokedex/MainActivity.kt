package com.example.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.adapter.PokemonAdapter
import com.example.pokedex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val adapter by lazy {
        PokemonAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.pokelista.layoutManager = LinearLayoutManager(this)
        binding.pokelista.adapter = adapter
        binding.pokelista.setHasFixedSize(true)

        binding.searchBtn.setOnClickListener {
            var intent = Intent(this@MainActivity, PokemonDetailsActivity::class.java)
            intent.putExtra("goal", binding.pokemonSearchET.text.toString())
            startActivity(
                intent
            )
        }

        binding.logoutBtn.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Cerrar sesión")
                .setMessage("¿Seguro que desea cerrar su sesión?")
                .setNegativeButton("NO") { dialog, view ->
                    dialog.dismiss()
                }.setPositiveButton("SI") { dialog, view ->
                    finish()
                    startActivity(
                        Intent(this@MainActivity, LoginActivity::class.java)
                    )
                }.show()
        }

    }
}