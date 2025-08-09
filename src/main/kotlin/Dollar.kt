class Dollar(
    amount: Int
) {
    private val amount: Int = amount

    fun times(multiplier: Int): Int {
        return this.amount * multiplier
    }

    override fun equals(other: Any?): Boolean {
        if (other is Dollar) {
            return this.amount == other.amount
        }

        return false
    }
}