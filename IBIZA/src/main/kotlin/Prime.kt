import java.math.BigInteger
import kotlin.random.Random
import kotlin.random.asJavaRandom

class Prime {
    fun largePrime(bits: Int): BigInteger {
        return BigInteger.probablePrime(bits, Random.asJavaRandom())
    }
}