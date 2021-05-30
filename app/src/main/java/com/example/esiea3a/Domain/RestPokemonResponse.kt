package com.example.esiea3a.Domain

class RestPokemonResponse{
    private val count: Int? = null
    private val next: String? = null
    private val results: MutableList<Pokemon>? = null

    fun getCount(): Int? {
        return count
    }

    fun getNext(): String? {
        return next
    }

    fun getResults(): MutableList<Pokemon>? {
        return results
    }
}