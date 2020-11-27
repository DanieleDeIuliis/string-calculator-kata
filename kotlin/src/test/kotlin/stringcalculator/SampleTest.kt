package stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SampleTest {

    @Test
    fun `return 0 when an empty string is passed`() {
        val stringCalculator = StringCalculator()
        assertEquals(0, stringCalculator.add(""))
    }

    @Test
    fun `return a number when a single number is passed`() {
        val stringCalculator = StringCalculator()
        assertEquals(1, stringCalculator.add("1"))
        assertEquals(2, stringCalculator.add("2"))
    }

    @Test
    fun `return the sum of two numbers`() {
        val stringCalculator = StringCalculator()
        assertEquals(3, stringCalculator.add("1,2"))
    }

    @Test
    fun `return the sum of all numbers when more than two are passed`() {
        val stringCalculator = StringCalculator()
        assertEquals(10, stringCalculator.add("1,2,3,4"))
    }

    @Test
    fun `return the sum of all the numbers when new line is a separator`() {
        val stringCalculator = StringCalculator()
        assertEquals(6, stringCalculator.add("1,2\n3"))
    }

    @Test
    fun `return the sum when a customer delimiter is passed`(){
        val stringCalculator = StringCalculator()
        assertEquals(6,stringCalculator.add("//>\n1>2\n3"))
    }
    @Test(expected = NegativeNumberNotAllowed::class)
    fun `throws NegativeNumberNotAllowed when a negative number is passed`(){
        val stringCalculator = StringCalculator()
        stringCalculator.add("1,-1")
    }

    @Test
    fun `return NegativeNumberNotAllowed with the list of numbers when negatives are passed`(){
        val stringCalculator = StringCalculator()
        try{
            stringCalculator.add("1,-1,-2")
        }catch (e: NegativeNumberNotAllowed){
            assertEquals("negative numbers not allowed: [-1, -2]", e.message)
        }
    }

    @Test
    fun `return the sum of numbers ignoring numbers greater than 1000`(){
        val stringCalculator = StringCalculator()
        assertEquals(10, stringCalculator.add("1,2,3,4,1000,1001,9999"))
    }
}