class Sum(
    augend: Money,
    addend: Money
) : Expression {
    val augend = augend
    val addend = addend

    override fun reduce(currency: String): Money {
        return Money(augend.amount + addend.amount, currency)
    }

    override fun reduce(bank: Bank, currency: String): Money {
        val amount = augend.amount + addend.amount
        return Money(amount, currency)
    }
}