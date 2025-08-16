package money

import Bank
import Expression
import Money
import Sum
import kotlin.test.*

class MoneyTest {

    @Test
    fun testPlusSameCurrencyReturnsMoney() {
        val sum = Money.dollar(1).plus(Money.dollar(1))
        assertTrue { sum is Money }
    }

    @Test
    fun testSumTimes() {
        val fiveBucks = Money.dollar(5)
        val tenFrancs = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val sum = Sum(fiveBucks, tenFrancs).times(2)
        val result = bank.reduce(sum, "USD")
        assertEquals(result, Money.dollar(20))
    }

    @Test
    fun testSumPlusMoney() {
        val fiveBucks = Money.dollar(5)
        val tenFrancs = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val sum = Sum(fiveBucks, tenFrancs).plus(fiveBucks)
        val result = bank.reduce(sum, "USD")
        assertEquals(result, Money.dollar(15))

    }

    @Test
    fun testMixedAddition() {
        val fiveBucks: Expression = Money.dollar(5)
        val tenFrancs: Expression = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(fiveBucks.plus(tenFrancs), "USD")
        assertEquals(Money.dollar(10), result)
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
        assertEquals(1, Bank().rate("CHF", "CHF"))
    }

    @Test
    fun testArrayEquals() {
        assertContentEquals(listOf("abc"), listOf("abc"))
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(Money.franc(2), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testReduceMoney() {
        val bank = Bank()
        val result = bank.reduce(Money.dollar(1), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testReduceSum() {
        val sum = Sum(Money.dollar(3), Money.dollar(4))
        val bank = Bank()
        val result = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(7), result)
    }

    @Test
    fun testPlusReturnsSum() {
        val five = Money.dollar(5)
        val result = five.plus(five)
        val sum = result as Sum
        assertEquals(five, sum.augend)
        assertEquals(five, sum.addend)
    }

    @Test
    fun testSimpleAddition() {
        val five = Money.dollar(5)
        val sum: Expression = five + five
        val bank = Bank()
        val reduced = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }

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
        assertFalse { Money.dollar(5) == Money.franc(6) }
    }

    @Test
    fun testFrancMultiplication() {
        val five = Money.franc(5)
        assertEquals(Money.franc(10), five.times(2))
        assertEquals(Money.franc(15), five.times(3))
    }
}