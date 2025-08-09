package money

import Dollar
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {
    @Test
    fun testMultiplication() {
        val five = Dollar(5)
        var product = five.times(2)
        assertEquals(expected = 10, actual = product)
        product = five.times(3)
        assertEquals(15, product)
    }

    @Test
    fun testEquality() {
        assertTrue { Dollar(5) == Dollar(5) }
        assertFalse { Dollar(5) == Dollar(6) }
    }
}