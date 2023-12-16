package com.example.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmleruygulamasi.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var kategoriliste:ArrayList<Kategoriler>
    private lateinit var adapter: KategoriAdapter
    private lateinit var veritabaniYardimcisi: VeritabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        veritabaniKopyala()

        binding.toolbarKategori.title = "Kategoriler"
        setSupportActionBar(binding.toolbarKategori)

        binding.rvKategori.setHasFixedSize(true)
        binding.rvKategori.layoutManager = LinearLayoutManager(this)

        veritabaniYardimcisi = VeritabaniYardimcisi(this)
        kategoriliste= Kategorilerdao().tumKategoriler(veritabaniYardimcisi)
        adapter = KategoriAdapter(this,kategoriliste)
        binding.rvKategori.adapter= adapter


    }

    fun veritabaniKopyala(){
        val db = DatabaseCopyHelper(this)
        try {
            db.createDataBase()
            db.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}