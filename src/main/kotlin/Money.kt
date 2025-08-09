open class Money(
    amount: Int
) {
    protected val amount: Int = amount

    open fun times(multiplier: Int): Money {
        return Money(amount * multiplier)
    }

    override fun equals(other: Any?): Boolean {
        if (other is Money) {
            return this.amount == other.amount
        }
        return false
    }
}