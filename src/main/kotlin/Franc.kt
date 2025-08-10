class Franc(
    amount: Int,
    currency: String = "CHF",
) : Money(amount, currency) {

    override fun toString(): String = "$amount $currency"
}