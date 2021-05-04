import java.math.BigInteger

class Encrypt: IEncrypt {
    override fun encrypt(message: BigInteger, e: BigInteger, n: BigInteger): BigInteger {
        return message.modPow(e,n)
    }
    override fun decrypt(message: BigInteger, d: BigInteger, n: BigInteger): BigInteger {
        return message.modPow(d,n)
    }
    override fun stringToCipheredString(string: String): BigInteger {
        val message = string.toUpperCase()
        var cipherString = ""
        var i = 0
        while (i < message.length) {
            val ch = message[i].toInt()
            cipherString += ch
            i++
        }
        return BigInteger(cipherString)
    }
    override fun cipheredStringToString(message: BigInteger): String{
        val cipherString = message.toString()
        var output = ""
        var i = 0
        while (i < cipherString.length){
            val char: Char = cipherString.substring(i,i+2).toInt().toChar()
            output += char
            i += 2
        }
        return output
    }
}