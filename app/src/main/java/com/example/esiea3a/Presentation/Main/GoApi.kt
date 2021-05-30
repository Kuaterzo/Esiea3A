package com.example.esiea3a.Presentation.Main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.esiea3a.Data.PokemonAPI
import com.example.esiea3a.R
import com.example.esiea3a.Data.ListAdapter
import com.example.esiea3a.Domain.Pokemon
import com.example.esiea3a.Domain.RestPokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GoApi : AppCompatActivity() {


    var mAdapter: ListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_api)

        
        //soucie de reconnaisence "
        
        activity_main1.layoutManager = LinearLayoutManager(this)

        makeApiCall()
    }
    
    fun ShowPokemon(listPokemon: MutableList<Pokemon>?) {
        
        mAdapter = ListAdapter(listPokemon ,this)
        activity_main1?.adapter = mAdapter;

    }

    fun makeApiCall() {
        
        val BASE_URL: String = "https://pokeapi.co/"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PokemonAPI::class.java)
        val Pokemon = service.getPokemonResponse()
        Pokemon.enqueue(object : Callback<RestPokemonResponse> {
            override fun onFailure(call: Call<RestPokemonResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<RestPokemonResponse>, response: Response<RestPokemonResponse>
            ) {

                var pokemonList: MutableList<Pokemon>? = response.body()?.getResults()
                ShowPokemon(pokemonList)
                
            }

        })


    }

}

