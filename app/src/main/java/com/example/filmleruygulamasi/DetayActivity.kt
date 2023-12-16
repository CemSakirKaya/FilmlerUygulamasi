package com.example.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmleruygulamasi.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val film = intent.getSerializableExtra("film") as Filmler

        binding.textViewFilmAd.text = film.film_ad
        binding.textViewFilmYil.text = film.film_yil.toString()
        binding.textViewYonetmen.text = film.yonetmen.yonetmen_ad
        binding.imageViewFilmResim.setImageResource(resources.getIdentifier(film.film_resim,"drawable",packageName))
    }
}