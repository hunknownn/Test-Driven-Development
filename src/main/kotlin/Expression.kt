interface Expression {
    fun reduce(currency: String) : Money
}