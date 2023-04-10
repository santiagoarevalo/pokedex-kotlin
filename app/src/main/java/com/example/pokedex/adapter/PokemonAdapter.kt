package com.example.pokedex.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.pokedex.PokemonDetailsActivity

import com.example.pokedex.model.Pokemon
import com.example.pokedex.viewholders.PokemonVH
import com.example.pokedex.R

class PokemonAdapter : Adapter<PokemonVH>() {

    val arr = ArrayList<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVH {
        return PokemonVH(
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: PokemonVH, position: Int) {
        holder.pokemonName.text = arr[position].name
        holder.actionBtn.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(holder.itemView.context, PokemonDetailsActivity::class.java)
            )
        }
    }

    fun addAllPokemons(pokemons: ArrayList<Pokemon>) {
        arr.addAll(pokemons)
        notifyDataSetChanged()
    }


}