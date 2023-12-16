package com.example.filmleruygulamasi

class Kategorilerdao {


    fun tumKategoriler(veritabaniYardimcisi: VeritabaniYardimcisi) : ArrayList<Kategoriler>{
        val db = veritabaniYardimcisi.writableDatabase
        val kategoriliste = ArrayList<Kategoriler>()

        val c = db.rawQuery("SELECT * FROM kategoriler",null)

        while (c.moveToNext()){
            var kategori = Kategoriler(c.getInt(c.getColumnIndexOrThrow("kategori_id"))
            ,c.getString(c.getColumnIndexOrThrow("kategori_ad")))
            kategoriliste.add(kategori)
        }
        return kategoriliste
    }

}