package stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SampleTest {

    @Test
    fun `returns 0 with empty string`() {
        val stringCalculator = StringCalculator()
        assertEquals(0, stringCalculator.add(""))
    }

    @Test
    fun `returns the number with only one number`() {
        val stringCalculator = StringCalculator()
        assertEquals(1, stringCalculator.add("1"))
        assertEquals(3, stringCalculator.add("3"))
    }

    @Test
    fun `returns the sum of two numbers`() {
        val stringCalculator = StringCalculator()
        assertEquals(3, stringCalculator.add("1,2"))
    }

    @Test
    fun `returns the sum of some more numbers`() {
        val stringCalculator = StringCalculator()
        assertEquals(10, stringCalculator.add("1,2,3,4"))
    }

    @Test
    fun `return the sum of two numbers when the delimiter is new line` (){
        val stringCalculator = StringCalculator()
        assertEquals(3, stringCalculator.add("1\n2"))
    }

    @Test
    fun `return the sum of two numbers with delimiter at the begin of the input` (){
        val stringCalculator = StringCalculator()
        assertEquals(3, stringCalculator.add("//$\n1$2"))
    }

    @Test
    fun `return the sum of some numbers with custom delimiter and new line separator` (){
        val stringCalculator = StringCalculator()
        assertEquals(6, stringCalculator.add("//$\n1$2\n3"))
    }

}