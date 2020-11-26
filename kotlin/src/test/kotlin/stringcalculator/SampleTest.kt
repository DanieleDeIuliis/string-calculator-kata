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
        assertEquals(3, stringCalculator.add("//$1$2"))
    }

}