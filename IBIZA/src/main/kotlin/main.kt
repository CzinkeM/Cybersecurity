fun main() {
    // find 2 large prime
    val p = Prime().largePrime(256)
    val q = Prime().largePrime(256)
    // calculate n
    val n = Calculation().n(p,q)
    // calculate phi
    val phi = Calculation().getPhi(p,q)
    // get e
    val e = Calculation().getE(phi)
    // calculate d
    val d = Calculation().extendedEuclidean(e,phi)[1]

    println("p: $p")
    println("q: $q")
    println("n: $n")
    println("Phi: $phi")
    println("e: $e")
    println("d: $d")

    val message = "This is a test text"
    println("Original: $message")
    val cipherMessage = Encrypt().stringToCipheredString(message)
    println("Ciphered: $cipherMessage")
    val encrypted = Encrypt().encrypt(cipherMessage,e,n)
    println("Encrypted: $encrypted")
    val decrypted = Encrypt().decrypt(encrypted,d, n)
    println("Decrypted: $decrypted")
    val restoredMessage = Encrypt().cipheredStringToString(decrypted)
    println("Restored: $restoredMessage")
}