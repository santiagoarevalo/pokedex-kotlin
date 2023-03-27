package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedex.databinding.ActivityLoginBinding
import com.example.pokedex.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}