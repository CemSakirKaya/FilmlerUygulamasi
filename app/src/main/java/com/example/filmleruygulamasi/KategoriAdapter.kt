package com.example.filmleruygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class KategoriAdapter(private val mcontext:Context,private val kategoriliste:List<Kategoriler>)
    : RecyclerView.Adapter<KategoriAdapter.TasarimNesneleriTutucu>(){

    inner class TasarimNesneleriTutucu(tasarim:View):RecyclerView.ViewHolder(tasarim){
        var kategori_card:CardView
        var textViewKategoriAd:TextView

        init {
            kategori_card= tasarim.findViewById(R.id.kategori_card)
            textViewKategoriAd= tasarim.findViewById(R.id.textViewKategoriAd)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasarimNesneleriTutucu {
        val tasarim = LayoutInflater.from(mcontext).inflate(R.layout.kategori_card_tasarim,parent,false)
        return TasarimNesneleriTutucu(tasarim)
    }

    override fun getItemCount(): Int {
       return kategoriliste.size
    }

    override fun onBindViewHolder(holder: TasarimNesneleriTutucu, position: Int) {
        var kategori = kategoriliste.get(position)

        holder.textViewKategoriAd.text = kategori.kategori_ad

        holder.kategori_card.setOnClickListener{
            val intent = Intent(mcontext,FilmlerActivity::class.java)
            intent.putExtra("kategori",kategori)
            mcontext.startActivity(intent)



        }

    }


}