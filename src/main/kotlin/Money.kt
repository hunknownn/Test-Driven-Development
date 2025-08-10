abstract class Money(
    amount: Int
) {
    protected val amount: Int = amount

    companion object {
        fun dollar(amount: Int): Money = Dollar(amount)

        fun franc(amount: Int): Money = Franc(amount)
    }

    abstract fun times(multiplier: Int): Money

    override fun equals(other: Any?): Boolean {
        if (other is Money) {
            if (this.javaClass != other.javaClass) return false
            return this.amount == other.amount
        }
        return false
    }
}