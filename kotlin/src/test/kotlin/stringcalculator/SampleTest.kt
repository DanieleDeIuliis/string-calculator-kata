package stringcalculator

import org.junit.Assert.assertTrue
import org.junit.Test

class SampleTest {

    @Test
    fun creationOfAStringCalculator() {
        val stringCalculator = StringCalculator()
        assertTrue(stringCalculator != null)
    }
}