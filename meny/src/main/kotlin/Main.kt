fun main(args: Array<String>) {
    menu() // Kalla menyfunktionen
}

fun menu() {

    //Simpel meny
    println("1 -> Addera tal")
    println("2 -> Räkna en string")
    println("3 -> Spegelvänd en string")
    println("4 -> Addera ihop en string")
    println("e för att avsluta")

    var input :String = readln()

    when(input) { // Kalla funktioner beroende på input
        "1" -> addSum()
        "2" -> countString()
        "3" -> reverseString()
        "4" -> sumString()
        "e" -> return

        else -> {
            println("Finns inte!") // Starta loopen igen om användaren ger felaktig input
            menu()
        }
    }
}

fun addSum() {
    var a = 0
    var b = 0

    print("\nFörsta numret: ")
    a = readln().toInt() ?: 0

    print("\nAndra numret: ")
    b = readln().toInt() ?: 0

    println("Svar: " + a + b)

    menu()
}

fun countString() {

    print("\nSkriv in ordet du vill leta i: ")
    var stringInput :String = readln() ?: "empty"

    print("\nSkriv in karaktären du vill leta efter: ")
    var charInput :Char = readln()[0] ?: 'a'

    var intLength = stringInput.filter { it == charInput }.count() // räkna antalet liknande char i stringen
    println(intLength)

    menu()
}

fun reverseString() {

    print("\nSkriv in ett ord: ")
    var stringInput :String = readln() ?: "empty"

    var stringReversed = stringInput.reversed()
    println(stringReversed)

    menu()
}

fun sumString() {

    print("\nSkriv in några siffror")
    var stringInput :String = readln() ?: "12"

    var intList = stringInput.map { it.digitToInt() }

    println(intList.sum())

    menu()
}