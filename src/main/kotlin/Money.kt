open class Money(
    amount: Int,
    currency: String,
) {

    companion object {
        fun dollar(amount: Int): Money = Dollar(amount)

        fun franc(amount: Int): Money = Franc(amount)
    }

    protected val amount: Int = amount

    protected val currency: String = currency

    open fun times(multiplier: Int): Money = Money(amount * multiplier, currency)

    open fun currency(): String = currency

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