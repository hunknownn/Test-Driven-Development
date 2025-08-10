class Franc(
    amount: Int
) : Money(amount, "CHF") {

    override fun times(multiplier: Int): Money {
        return franc(amount * multiplier)
    }

    override fun currency(): String = currency
}