interface Expression {
    fun reduce(currency: String) : Money
    fun reduce(bank: Bank, currency: String) : Money
}