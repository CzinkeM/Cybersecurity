import java.math.BigInteger
import kotlin.random.Random
import kotlin.random.asJavaRandom

class Prime {
    // TODO: 5/3/21  implement random prime generator
    /**
     * Generates a random large prime number of specified bitlength
     *
     */
    fun largePrime(bits: Int):BigInteger {
        var randomInteger = Random.asJavaRandom()
        return BigInteger.probablePrime(bits,randomInteger)
    }
}