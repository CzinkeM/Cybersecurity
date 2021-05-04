import java.math.BigInteger
import kotlin.random.Random
import kotlin.random.asJavaRandom

class Calculation {
    fun n(p: BigInteger, q: BigInteger): BigInteger {
        return p.multiply(q)
    }
    fun getPhi(p: BigInteger, q: BigInteger): BigInteger{
        return (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE))
    }

    fun extendedEuclidean(a: BigInteger, b: BigInteger): Array<BigInteger>{
        if(b.equals(BigInteger.ZERO)) return arrayOf(a,BigInteger.ONE, BigInteger.ZERO)
        val values = extendedEuclidean(b, a.mod(b))
        val d = values[0]
        val p = values[2]
        val q = values[1].subtract(a.divide(b).multiply(values[2]))
        return arrayOf(d,p,q)
    }
    fun getE(phi: BigInteger):BigInteger {
        val random = Random.asJavaRandom()
        var e: BigInteger
        do{
            e = BigInteger(512,random)
            while (e.min(phi).equals( phi)) {
                e = BigInteger(512, random)
            }
        }while (gcd(e,phi) != BigInteger.ONE)
        return e
    }
    private fun gcd(a: BigInteger,b: BigInteger): BigInteger{
        return if(b.equals( BigInteger.ZERO)) {
            a
        }else{
            gcd(b,a.mod(b))
        }
    }

}