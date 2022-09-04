var wordCorrect: String = "empty" //Hemliga ordet
var tries: Int = 3 // Hur många försök man har på sig
var gameActive: Boolean = false // Om spelet är igång
var wordGuess: Char = 'a' // Input från användaren
var guessList: MutableList<String> = MutableList(0) { "_" } // En lista där användarens korrekta gissningar lagras
var correctAnswer: Boolean = false // om det var rätt svar

fun main() {
    menu() // Starta menyn
}

fun menu() {
    println("Välkommen till hänga gubbe!")
    println("\nHur många försök vill du ha på dig?")
    tries = readln().toInt() ?: 3

    println("Skriv S för att starta spelet eller Q för att avsluta det..")

    var input: Char = readln()[0].uppercaseChar()

    when(input) {
        'S' -> startGame()
        'Q' -> return
    }
}

fun startGame() { // Initalisera spelet
    val wordList = listOf("VÄXT", "APA", "HUND", "DATABAS", "TELEVISION", "LÄSK", "STOCKHOLM", "FEST", "DJUR", "SKOG")
    wordCorrect = wordList.random() // Välj ett slumpmässigt ord från listan ovanför

    guessList = MutableList(wordCorrect.length) { "_" } // Skapa hemliga ordets interface

    gameActive = true // Sätt gameactive till sant
    gameLoop() // Starta spelet
}

fun gameLoop() {
    while(gameActive == true) { // Medan gameActive = true loopa spelet

        correctAnswer = false // Återställ correctAnswer till false

        displayGuess() // Visa antalet korrekta gissningar och ordets längd

        if(!guessList.contains("_")) { // Om guessList inte har några _ kvar vann spelaren
            println("Du vann")
            gameActive = false
            menu()
        } else if(tries == 0) { // Om 0 försök kvar
            println("Du förlorade!")
            gameActive = false
            menu()
        }

        println("Skriv din gissning")
        wordGuess = readln()[0].uppercaseChar() // Användarens input

        for(i in 0 until wordCorrect.length) { // Loopa ordets längd

            if(wordGuess == wordCorrect[i]) { // Om inputen var rätt någonstans i rangen
                guessList.set(i, wordGuess.toString()) // Ändra guessList från _ till korrekt bokstav
                correctAnswer = true // Svaret var rätt
            }
        }

        if(correctAnswer == false) { // Om svaret inte var rätt, ta bort ett försök
            tries--
        }

    }
}

fun displayGuess() { // Funktion för att printa rätt gissningar
    for(i in 0 until wordCorrect.length) {
        print(guessList[i])
    }
    println()
}