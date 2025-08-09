class Franc(
    amount: Int
) {
    private val amount: Int = amount

    fun times(multiplier: Int): Franc {
        return Franc(this.amount * multiplier)
    }

    override fun equals(other: Any?): Boolean {
        if (other is Franc) {
            return this.amount == other.amount
        }

        return false
    }
}