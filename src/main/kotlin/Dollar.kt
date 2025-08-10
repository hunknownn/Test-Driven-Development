class Dollar(
    amount: Int
) : Money(amount, "USD") {

    override fun times(multiplier: Int): Money {
        return dollar(amount * multiplier)
    }

    override fun currency(): String = currency
}