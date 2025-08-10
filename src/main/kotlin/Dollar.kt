class Dollar(
    amount: Int,
    currency: String = "USD",
) : Money(amount, currency) {

    override fun toString(): String = "$amount $currency"
}