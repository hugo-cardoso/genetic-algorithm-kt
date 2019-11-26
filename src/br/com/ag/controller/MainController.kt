package br.com.ag.controller

import br.com.ag.model.Chromo

class MainController(
    var text: String,
    var populationSize: Int
) {
    private var textLength: Int = text.length
    private var result: String = Array(textLength) { "-" }.joinToString("")
    private var isFinished: Boolean = false
    private var generation: Int = 1
    private var hereditary: Chromo = Chromo("",0,"")

    fun init() {

        while( !this.isFinished ) {

            var population = Population()

            if( this.generation == 1 ) {
                population.create(
                    populationSize,
                    this.result,
                    this.result
                )
            }
            else {
                population.create(
                    populationSize - 1,
                    this.result,
                    this.hereditary.result
                )
                population.add(hereditary)
            }

            val searchedPopulation = SearchController(this.text).search(population)
            population = searchedPopulation
            hereditary = population.getHereditary()
            this.result = hereditary.result

            println(this.generation)

            if(this.result == this.text) {
                this.isFinished = true
            }

            this.generation += 1
        }
    }
}