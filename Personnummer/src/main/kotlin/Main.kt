var personNummer :Long = 0
var input :String = "0"
fun main(args: Array<String>) {
    val nonAlphaNum = "[^0,1,2,3,4,5,6,7,8,9]".toRegex() //Endast dessa karaktärerna får finnas kvar i stringen
    while(personNummer < 1) { // Om variabeln personnummer är tom, loopa koden
        println("Skriv in ditt 10 eller 12 siffriga personnummer: ")
        input = readLine().toString().replace(nonAlphaNum, "") // ta input och ta ut alla otillåtna karaktärer
        println(input.length)

        if (input.length > 12) { // om
            println("För många siffror!")

        } else if(input.length > 10 && input.length < 13) {
            input = input.drop(1)
            input = input.drop(1)
            break
        }
        else {
            break
        }
    }


    if(Luhn.isValid(input)) {
        print("Giltigt personnummer!")
    }

    else {
        println("Ogiltigt personnummer!")
    }
}

object Luhn {
    fun isValid(s: String): Boolean {


        val strReplaceSpace = s.replace(" ", "")

        if(strReplaceSpace.length < 2) return false
        val sum = strReplaceSpace
            .mapIndexed { index, c ->
                if(!c.isDigit())
                    return false
                if(checkDouble(index, strReplaceSpace.length))
                    c.toString().toInt() * 2
                else
                    c.toString().toInt()
            }
            .map {
                if(it > 9)
                    it - 9
                else
                    it
            }
            .sum()

        return sum % 10 == 0
    }

    private fun checkDouble(index:Int, strLength: Int): Boolean =
        if(strLength % 2 != 0)
            index % 2 != 0
        else
            index % 2 == 0

}