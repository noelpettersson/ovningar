fun main(args: Array<String>) {
    //Meny för programmet
    println("Välj vilket mått du vill omvandla till centimeter: ")
    println("1. Tum")
    println("2. Famnar")
    println("3. Fot")
    println("4. Alnar")

    println("\n")
    var input = readLine() // Input som används till when statement för att se vilken funktion användaren vill använda
    println("Skriv in måttet: ")
    var sum :Float = readLine()!!.toFloat() // Numret användaren vill omvandla, konvertera string till float


    when (input) {
        "1" -> println(sum / 0.39370)
        "2" -> println(sum * 18288)
        "3" -> println(sum * 30.48)
        "4" -> println(sum * 59.38)

        else -> println("Felaktig input..")
    }
}
