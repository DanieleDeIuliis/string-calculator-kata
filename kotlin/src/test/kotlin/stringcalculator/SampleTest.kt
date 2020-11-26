package stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SampleTest {

    @Test
    fun creationOfAStringCalculator() {
        val stringCalculator = StringCalculator()
        assertTrue(stringCalculator != null)
    }

    @Test
    fun addEmptyString(){
        val stringCalculator = StringCalculator()
        assertEquals(0, stringCalculator.add(""))
    }

    @Test
    fun addSpacesString(){
        val stringCalculator = StringCalculator()
        assertEquals(0, stringCalculator.add("     "))
    }

    @Test
    fun addOneNumberString(){
        val stringCalculator = StringCalculator()
        assertEquals(1, stringCalculator.add("1"))
    }

    @Test
    fun addTwoNumberString(){
        val stringCalculator = StringCalculator()
        assertEquals(3, stringCalculator.add("1,2"))
    }

    @Test
    fun addTwoNumberWithNewLineSeparatorString(){
        val stringCalculator = StringCalculator()
        assertEquals(3, stringCalculator.add("1\n2"))
    }

    @Test
    fun addTwoNumberCustomSeparatorString(){
        val stringCalculator = StringCalculator()
        assertEquals(3, stringCalculator.add("//$\n1$2"))
    }

    @Test
    fun `return the sum of some numbers with custom prefix and new line in separetors`(){
        val stringCalculator = StringCalculator()
        assertEquals(6, stringCalculator.add("//$\n1$2\n3"))
    }

    @Test(expected = NegativeNumberNotAllowed::class)
    fun `throws NegativeNumberNotAllowed when a negative number is passed`() {
        val stringCalculator = StringCalculator()
            stringCalculator.add("1,-1")
    }

    @Test
    fun `throws NegativeNumberNotAllowed when some negative numbers are passed`() {
        val stringCalculator = StringCalculator()
        try{
            stringCalculator.add("1,-1,-2")
        }catch (e: NegativeNumberNotAllowed){
            assertEquals("negatives not allowed: [-1, -2]",e.message)
        }
    }

    @Test
    fun `ignore numbers greater than 1000`() {
        val stringCalculator = StringCalculator()
        assertEquals(10, stringCalculator.add("1,2,3,4,1000,2000"))
    }

}