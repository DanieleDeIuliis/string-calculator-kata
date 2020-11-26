package stringcalculator

class StringCalculator {
    fun add(text: String): Int {
        if(text.isEmpty())
            return 0

        var (delimiter, numbers) = "(//.*\n)(.*)".toRegex().find(text)!!.destructured
        delimiter = delimiter.substring(2)
        println("$delimiter  $numbers")

        if(numbers.length > 1) {
            return numbers.split(delimiter,"\n").map { it.toInt() }.sum()
        }
        return numbers.toInt()
    }

}
