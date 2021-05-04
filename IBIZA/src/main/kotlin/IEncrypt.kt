import java.math.BigInteger

interface IEncrypt {
    fun encrypt(message: BigInteger, e: BigInteger, n: BigInteger): BigInteger
    fun decrypt(message: BigInteger, d: BigInteger, n: BigInteger): BigInteger
    fun stringToCipheredString(string: String): BigInteger
    fun cipheredStringToString(message: BigInteger): String
}