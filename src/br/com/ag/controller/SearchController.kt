package br.com.ag.controller

class SearchController(private val text: String) {

    fun search(population: Population): Population {

        for ( chromo in population.get() ) {
            var searched = ""
            var score = 0
            for( i in 0 until chromo.result.length) {

                if( chromo.hereditaryResult[i] == this.text[i] ) {
                    searched += this.text[i]
                    score++
                }
                else if(chromo.hereditaryResult[i] == '-') {
                    searched += this.getRandomLetter()
                    if( searched[i] == this.text[i] ) {
                        score++
                    }
                }
                else {
                    searched += '-'
                }
            }
            chromo.result = searched
            chromo.score = score
        }
        return population
    }

    private fun getRandomLetter(): String {
        val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz"
        return (1..1)
            .map { allowedChars.random() }
            .joinToString("")
    }
}