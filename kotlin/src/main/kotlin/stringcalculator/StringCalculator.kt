package stringcalculator

class  StringCalculator {
    fun add(text: String): Int {
        if(text.isEmpty())
            return 0
        val delimiterWithPrefixAndSuffix = "//.*\n".toRegex().find(text)?.value
        val delimiter = delimiterWithPrefixAndSuffix?.removeSurrounding("//","\n") ?: ","
        val numbers = text.removePrefix("//$delimiter\n")
        val (positives, negatives) = numbers.split(delimiter,"\n").map { it.toInt() }.filter { it < 1000 }.partition { it > 0 }
        if(negatives.isEmpty()){
            return positives.sum()
        }else{
            throw NegativeNumberNotAllowed("negative numbers not allowed: $negatives")
        }
    }

}
