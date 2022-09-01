fun main(args: Array<String>) {

    //Variabler
    var randomNumber :Int = 0
    var input :Int
    var tries :Int = 2
    var userGuess :Int = 0
    // Printa ut menyn
    println("1. Lätt (1-10)")
    println("2. Medel (1-100)")
    println("3. Svårt (1-1000)")

    println("Välj svårighetsgrad: ")
    input = readLine()!!.toInt() // Läs input till menyn
    when(input) { // Välj vilken range som ska genereras efter användarens input
        1 -> randomNumber = (0..10).random()
        2 -> randomNumber = (0..100).random()
        3 -> randomNumber = (0..1000).random()
    }

    while(tries !== -1) { //Loopa till att användaren får slut på försök
        println("Gissa ett nummer: ")
        userGuess = readLine()!!.toInt() // Läs användarens gissning
        println("$tries försök kvar!")

        if (userGuess < randomNumber) { // Om gissningen var för låg
            println("För lågt!")
            tries--
        } else if (userGuess > randomNumber) { // Om gissningen var för hög
            println("För högt!")
            tries--
        } else if (userGuess == randomNumber){ // Om gissningen var rätt
            println("Rätt!")
            break // Avbryt loopen
        }
    }


}