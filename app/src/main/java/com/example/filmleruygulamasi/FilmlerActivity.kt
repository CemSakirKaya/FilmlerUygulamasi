package com.example.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmleruygulamasi.databinding.ActivityFilmlerBinding

class FilmlerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilmlerBinding
    private lateinit var filmlerliste:ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter
    private lateinit var veritabaniYardimcisi: VeritabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFilmlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kategori = intent.getSerializableExtra("kategori") as Kategoriler


        binding.toolbarFilmler.title= "Filmler : ${kategori.kategori_ad} "
        setSupportActionBar(binding.toolbarFilmler)

        binding.rvFilmler.setHasFixedSize(true)
        binding.rvFilmler.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        veritabaniYardimcisi=VeritabaniYardimcisi(this)
        filmlerliste = Filmlerdao().tumFilmlerByCategoriId(veritabaniYardimcisi,kategori.kategori_id)

        adapter= FilmlerAdapter(this,filmlerliste)
        binding.rvFilmler.adapter= adapter

    }
}