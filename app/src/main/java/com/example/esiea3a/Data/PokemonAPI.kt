package com.example.esiea3a.Data;

import com.example.esiea3a.Domain.RestPokemonResponse
import android.telecom.Call
import retrofit2.http.GET

interface PokemonAPI {

    //API pokedex pokemon
    @GET("/api/v2/pokemon?limit=807")
    fun getPokemonResponse (): Call<RestPokemonResponse>

}
