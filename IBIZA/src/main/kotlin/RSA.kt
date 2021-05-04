import java.math.BigInteger
import kotlin.random.Random
import kotlin.random.asJavaRandom

class RSA {
    /** 3. Compute Phi(n) (Euler's totient function)
     *  Phi(n) = (p-1)(q-1)
     *	BigIntegers are objects and must use methods for algebraic operations
     */
    fun getPhi(p: BigInteger, q: BigInteger): BigInteger{
        return (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE))
    }
    /**
     * Recursive implementation of Euclidian algorithm to find greatest common denominator
     * Note: Uses BigInteger operations
     */
    fun gcd(a: BigInteger,b: BigInteger): BigInteger{
        return if(b == BigInteger.ZERO) {
            a
        }else{
            gcd(b,a.mod(b))
        }
    }
    /** Recursive EXTENDED Euclidean algorithm, solves Bezout's identity (ax + by = gcd(a,b))
     * and finds the multiplicative inverse which is the solution to ax ≡ 1 (mod m)
     * returns [d, p, q] where d = gcd(a,b) and ap + bq = d
     * Note: Uses BigInteger operations
     */
    fun extEuclid(a: BigInteger,b: BigInteger): Array<BigInteger>{
        if(b == BigInteger.ZERO) return arrayOf(a,BigInteger.ONE, BigInteger.ZERO)
        val values = extEuclid(b, a.mod(b))
        val d = values[0]
        val p = values[2]
        val q = values[1].subtract(a.divide(b).multiply(values[2]))
        return arrayOf(d,p,q)
    }
    /**
     * generate e by finding a Phi such that they are coprimes (gcd = 1)
     *
     */
    fun genE(phi: BigInteger):BigInteger {
        val random = Random.asJavaRandom()
        var e: BigInteger
        do{
            e = BigInteger(1024,random)
            while (e.min(phi) == phi) {
                e = BigInteger(1024, random)
            }
        }while (gcd(e,phi) != BigInteger.ONE)
        return e
    }

    fun encrypt(message: BigInteger,e: BigInteger,n: BigInteger):BigInteger{
        return message.modPow(e,n)
    }
    fun decrypt(message: BigInteger,d:BigInteger,n: BigInteger): BigInteger{
        return message.modPow(d,n)
    }
    fun n(p:BigInteger,q: BigInteger):BigInteger{
        return p.multiply(q)
    }
    fun stringCipher(string: String): BigInteger {
        val message = string.toUpperCase()
        var cipherString = ""
        var i = 0
        while (i < message.length) {
            val ch: Int = message[i].toInt()
            cipherString += ch
            i++
        }
        return BigInteger(cipherString)
    }

    fun cipherToString(message: BigInteger): String{
        var cipherString = message.toString()
        var output = ""
        var i = 0
        while (i < cipherString.length){
            val char: Char = cipherString.substring(i,i+2).toInt().toChar()
            output += char
            i + i + 2
        }
        return output
    }
}