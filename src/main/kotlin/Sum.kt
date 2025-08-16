class Sum(
    augend: Expression,
    addend: Expression
) : Expression {
    val augend = augend
    val addend = addend

    override fun reduce(bank: Bank, currency: String): Money {
        val amount = augend.reduce(bank, currency).amount + addend.reduce(bank, currency).amount
        return Money(amount, currency)
    }

    override fun plus(addend: Expression): Expression {
        return Sum(this, addend)
    }

    override fun times(i: Int): Expression {
        return Sum(augend.times(i), addend.times(i))
    }
}