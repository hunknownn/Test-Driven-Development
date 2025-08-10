package money

import Money
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {
    @Test
    fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency())
        assertEquals("CHF", Money.franc(1).currency())
    }

    @Test
    fun testMultiplication() {
        val five = Money.dollar(5)
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun testEquality() {
        assertTrue { Money.dollar(5) == Money.dollar(5) }
        assertFalse { Money.dollar(5) == Money.dollar(6) }
        assertFalse { Money.franc(5) == Money.franc(6) }
        assertFalse { Money.franc(5) == Money.franc(6) }
        assertFalse { Money.dollar(5) == Money.franc(5) }
        assertFalse { Money.dollar(5) == Money.franc(6) }
    }

    @Test
    fun testFrancMultiplication() {
        val five = Money.franc(5)
        assertEquals(Money.franc(10), five.times(2))
        assertEquals(Money.franc(15), five.times(3))
    }
}