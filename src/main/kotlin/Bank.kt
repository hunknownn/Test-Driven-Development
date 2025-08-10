import java.util.Hashtable

class Bank {
    private val rates = Hashtable<Pair<String, String>, Int>()

    fun reduce(exp: Expression, currency: String): Money {
        return exp.reduce(this, currency)
    }

    fun addRate(s: String, s1: String, i: Int) {
        this.rates[Pair(s, s1)] = i

    }

    fun rate(from: String, to: String): Int {
        if (from == to) {
            return 1
        }
        return rates[Pair(from, to)] ?: 0
    }
}