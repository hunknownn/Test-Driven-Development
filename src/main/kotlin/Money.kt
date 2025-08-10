abstract class Money(
    amount: Int,
    currency: String,
) {
    protected val amount: Int = amount

    protected val currency: String = currency

    companion object {
        fun dollar(amount: Int): Money = Dollar(amount)

        fun franc(amount: Int): Money = Franc(amount)
    }

    abstract fun times(multiplier: Int): Money

    abstract fun currency() : String

    override fun equals(other: Any?): Boolean {
        if (other is Money) {
            if (this.javaClass != other.javaClass) return false
            return this.amount == other.amount
        }
        return false
    }
}