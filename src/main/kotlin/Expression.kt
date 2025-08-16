interface Expression {
    fun reduce(bank: Bank, currency: String): Money
    operator fun plus(addend: Expression): Expression
    fun times(multiplier: Int): Expression
}