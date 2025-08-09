class Dollar(
    amount: Int
) {
    var amount: Int = amount

    fun times(multiplier: Int): Int {
        this.amount *= multiplier
        return this.amount
    }
}