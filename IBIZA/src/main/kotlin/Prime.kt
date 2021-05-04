import java.math.BigInteger
import kotlin.random.Random
import kotlin.random.asJavaRandom

class Prime {
    fun largePrime(bits: Int):BigInteger {
        val randomInteger = Random.asJavaRandom()
        return BigInteger.probablePrime(bits,randomInteger)
    }
}