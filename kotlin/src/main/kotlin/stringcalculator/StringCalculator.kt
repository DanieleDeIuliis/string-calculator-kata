package stringcalculator

class StringCalculator {
    fun add(numbersToAdd: String): Int {
        if(numbersToAdd.trim().isEmpty())
            return 0
        val numbers = numbersToAdd.split(",")
        return numbers[0].toInt() + numbers[1].toInt()
    }
}