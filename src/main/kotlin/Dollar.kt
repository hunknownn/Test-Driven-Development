class Dollar(
    amount: Int
) {
    private val amount: Int = amount

    fun times(multiplier: Int): Int {
        return this.amount * multiplier
    }
}