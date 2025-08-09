package money

import Dollar
import kotlin.test.Test
import kotlin.test.assertEquals

class MoneyTest {
    @Test
    fun testMultiplication() {
        val five = Dollar(5)
        var product = five.times(2)
        assertEquals(expected = 10, actual = product)
        product = five.times(3)
        assertEquals(15, product)
    }
}