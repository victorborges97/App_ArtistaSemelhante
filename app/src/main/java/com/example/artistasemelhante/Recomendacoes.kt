package com.example.artistasemelhante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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

    }
}