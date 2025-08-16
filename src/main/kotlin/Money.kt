open class Money(
    amount: Int,
    currency: String,
) : Expression {

    companion object {
        fun dollar(amount: Int): Money = Dollar(amount)

        fun franc(amount: Int): Money = Franc(amount)
    }

    val amount: Int = amount

    protected val currency: String = currency

    override fun times(multiplier: Int): Expression = Money(amount * multiplier, currency)

    open fun currency(): String = currency

    override fun reduce(bank: Bank, currency: String): Money {
        val rate = bank.rate(this.currency, currency)
        return Money(amount / rate, currency)
    }

    override operator fun plus(addend: Expression): Expression {
        return Sum(this, addend)
    }

    override fun equals(other: Any?): Boolean {
        if (other is Money) {
            return this.currency == other.currency() && this.amount == other.amount
        }
        return false
    }

    override fun toString(): String {
        return "${this.javaClass}(amount=$amount, currency='$currency')"
    }
}