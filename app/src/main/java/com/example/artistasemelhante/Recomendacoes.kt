package com.example.artistasemelhante

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Recomendacoes : AppCompatActivity() {

    lateinit var recomendacao_um : TextView
    lateinit var recomendacao_dois : TextView
    lateinit var recomendacao_tres : TextView
    lateinit var recomendacao_quatro : TextView
    lateinit var recomendacao_cinco : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendacoes)

        recomendacao_um = findViewById(R.id.recomendacao_um)
        recomendacao_dois = findViewById(R.id.recomendacao_dois)
        recomendacao_tres = findViewById(R.id.recomendacao_tres)
        recomendacao_quatro = findViewById(R.id.recomendacao_quatro)
        recomendacao_cinco = findViewById(R.id.recomendacao_cinco)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://tastedive.com/read/api")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val artist: Artist = retrofit.create(Artist::class.java)
    }
}