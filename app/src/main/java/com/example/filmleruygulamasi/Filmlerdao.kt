package com.example.filmleruygulamasi

class Filmlerdao {

    fun tumFilmlerByCategoriId(veritabaniYardimcisi: VeritabaniYardimcisi,kategori_id:Int): ArrayList<Filmler>{
        val db = veritabaniYardimcisi.writableDatabase
        val filmliste = ArrayList<Filmler>()

        val c = db.rawQuery("SELECT * FROM  filmler,yonetmenler,kategoriler " +
                "WHERE filmler.kategori_id= kategoriler.kategori_id AND filmler.yonetmen_id= yonetmenler.yonetmen_id " +
                "AND filmler.kategori_id=$kategori_id\n",null)
        while (c.moveToNext()){
            var kategori = Kategoriler(c.getInt(c.getColumnIndexOrThrow("kategori_id"))
            ,c.getString(c.getColumnIndexOrThrow("kategori_ad")))

            var yonetmen= Yonetmenler(c.getInt(c.getColumnIndexOrThrow("yonetmen_id"))
            ,c.getString(c.getColumnIndexOrThrow("yonetmen_ad")))

            var film = Filmler(c.getInt(c.getColumnIndexOrThrow("film_id"))
            ,c.getString(c.getColumnIndexOrThrow("film_ad"))
            ,c.getInt(c.getColumnIndexOrThrow("film_yil"))
            ,c.getString(c.getColumnIndexOrThrow("film_resim"))
            ,kategori,yonetmen)
            filmliste.add(film)
        }
        return filmliste
    }

}