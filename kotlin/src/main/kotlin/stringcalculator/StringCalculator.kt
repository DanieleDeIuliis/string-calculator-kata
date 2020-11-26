package stringcalculator

class StringCalculator {
    fun add(text: String): Int {
        if(text.trim().isEmpty())
            return 0
        var delimiter = ","
        if(text.startsWith("//")){
            delimiter = text.split("\n").first().substring(2)
        }
        val numbers = text.removePrefix("//$delimiter\n")
        val (positiveNumbers, negativeNumbers) = numbers.split(delimiter,"\n")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
                .filter { it < 1000 }
                .partition { it > 0 }
        if(negativeNumbers.isNotEmpty())
            throw NegativeNumberNotAllowed("negatives not allowed: $negativeNumbers")
        return positiveNumbers.sum()
    }
}