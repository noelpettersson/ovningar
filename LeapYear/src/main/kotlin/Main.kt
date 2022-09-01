fun main(args: Array<String>) {
    println("Skriv in ett år: ")
    var year :Int = readLine()!!.toInt()

    if (year%4 == 0) {
        println("Skottår")
    } else {
        println("Inte skottår")
    }
}