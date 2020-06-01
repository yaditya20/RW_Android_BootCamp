fun main(){
    val blackJackController = GameController()
    val setCards: MutableSet<Card> = blackJackController.createDeck()
    val listCards: MutableSet<Card> = blackJackController.dealHand(setCards,2)
    val evaluateHand = blackJackController.evaluateHand(listCards)
    blackJackController.printResults(listCards,evaluateHand)
}