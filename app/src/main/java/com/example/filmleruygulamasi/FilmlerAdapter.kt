package com.example.filmleruygulamasi

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext:Context,private val filmlerliste:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.NesneTutucu>(){


        inner class NesneTutucu(tasarim:View): RecyclerView.ViewHolder(tasarim){
            var film_card : CardView
            var textViewFilmAd : TextView
            var imageViewFilmResim: ImageView

            init {
                film_card= tasarim.findViewById(R.id.film_card)
                textViewFilmAd= tasarim.findViewById(R.id.textViewFilmAd)
                imageViewFilmResim= tasarim.findViewById(R.id.imageViewFilmResim)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NesneTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.film_card_tasarim,parent,false)
        return NesneTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return filmlerliste.size
    }

    override fun onBindViewHolder(holder: NesneTutucu, position: Int) {
        var film = filmlerliste.get(position)

        holder.textViewFilmAd.text = film.film_ad
        holder.imageViewFilmResim.setImageResource(mContext.resources.getIdentifier(film.film_resim,"drawable",mContext.packageName))
        holder.film_card.setOnClickListener{
                val intent = Intent(mContext,DetayActivity::class.java)
                    intent.putExtra("film",film)
                    mContext.startActivity(intent)

        }
    }
}