package br.com.ag.controller

import br.com.ag.model.Chromo

class Population {

    var population: ArrayList<Chromo> = ArrayList()

    fun create(
        size: Int,
        result: String,
        hereditaryResult: String
    ) {
        for (i in 1..size) {
            var chromo = Chromo(result, i, hereditaryResult)
            population.add(chromo)
        }
    }

    fun add(chromo: Chromo) {
        population.add(chromo)
    }

    fun get(): ArrayList<Chromo> {
        return population
    }

    fun getHereditary(): Chromo {
        var highScore = this.population[0].score
        var hereditary=  this.population[0]

        for( chromo: Chromo in this.population ) {
            if( chromo.score > highScore ) {
                hereditary = chromo
            }
        }

        return hereditary
    }
}