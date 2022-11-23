package com.example.artistasemelhante

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
        val call: Call<List<PostArtist?>?>? = artist.getPosts("red+hot+chili+peppers%2C+pulp+fiction")

        call!!.enqueue(object : Callback<List<PostArtist?>?> {
            override fun onResponse(call: Call<List<PostArtist?>?>?, response: Response<List<PostArtist?>?>) {
                if (!response.isSuccessful()) {
                    Toast.makeText(
                        applicationContext,
                        "Code: " + response.code(),
                        Toast.LENGTH_SHORT
                    )
                    return
                }
                val postArtist: List<PostArtist> = response.body() as List<PostArtist>
                for (postArtist in postArtist) {

                    var recomendacao = ""
                    recomendacao = postArtist.getTitle().toString()
                    recomendacao_um.setText(title)
                }
            }

            override fun onFailure(call: Call<List<PostArtist?>?>?, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT)
            }
        })
    }
}