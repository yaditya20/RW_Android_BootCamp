class GameController{
    fun createDeck(): MutableSet<Card>{
        val pipList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
        val suitList = listOf('C', 'S', 'D', 'H')
        val cardSet = mutableSetOf<Card>()
        for (pip in pipList){
            for (suit in suitList){
                val card = Card(pip, suit)
                cardSet.add(card)
            }
        }
        return cardSet
    }

    fun dealHand(deck: MutableSet<Card>, numberOfCardsInHand: Int): MutableSet<Card>{
        val deckInHand = mutableSetOf<Card>()
        var hand = 0

        while (hand < numberOfCardsInHand) {
            val card = deck.random()
            deckInHand.add(card)
            deck.remove(card)
            hand ++
        }

        return deckInHand
    }

    fun evaluateHand(deckInHand: MutableSet<Card>): Int {
        var sumOfPipsValue = 0
        for (card in deckInHand) {
            when (card.pip) {
                1 -> sumOfPipsValue+=11
                11, 12, 13 -> sumOfPipsValue+=10
                else -> sumOfPipsValue+=card.pip
            }
        }
        return sumOfPipsValue
    }

    fun printResults(deckInHand: MutableSet<Card>, sumOfPipsValue: Int){
        println("\n Your Hand was:\n")
        val suitChar = arrayListOf<String>()
        val faceChar = arrayListOf<String>()

        deckInHand.forEachIndexed { index, card ->

            suitChar.add(when(card.suit){
                'H' -> "\u2665"
                'S' -> "\u2660"
                'D' -> "\u2666"
                'C' -> "\u2663"
                else -> ""
            })
            faceChar.add(when (card.pip) {
                1 -> "A"
                11 -> "J"
                12 -> "Q"
                13 -> "K"
                else -> "${card.pip}"
            })



        }
        // Jenn's Code, modified for above use case
        println("""
.------.                                              
|${faceChar[0]}     |          
|     .------.                                        
|   ${suitChar[0]} |${faceChar[1]}      |      
|     |       |                                        
|     |   ${suitChar[1]}   |        
`-----|       |
      |      ${faceChar[1]}|                                        
      `-------'""".trimIndent())
        println("\nFor a Total of $sumOfPipsValue")

        if(sumOfPipsValue == 21)
            println ("YOU WIN!")
        else
            println("YOU LOST!")
    }
}