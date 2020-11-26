package stringcalculator

class StringCalculator {
    fun add(numbersToAdd: String): Int {
        if(numbersToAdd.trim().isEmpty())
            return 0
        return numbersToAdd.split(",","\n").map { it.toInt() }.sum()
    }
}