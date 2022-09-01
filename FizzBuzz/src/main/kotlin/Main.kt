fun main(args: Array<String>) {


    for(i in 1..100) { // For loop som loopar 100 gånger
        if (i % 3 == 0 && i % 5 == 0) {
            println("FizzBuzz")
        } else if (i % 3 == 0) {
            println("Fizz")
        } else if (i % 5 == 0) {
            println("Buzz")
        } else {
            println(i)
        }
        Thread.sleep(100)
    }

}