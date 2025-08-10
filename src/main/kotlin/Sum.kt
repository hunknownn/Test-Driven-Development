class Sum(
    augend: Money,
    addend: Money
) : Expression {
    val augend = augend
    val addend = addend

    override fun reduce(currency: String): Money {
        return Money(augend.amount + addend.amount, currency)
    }
}