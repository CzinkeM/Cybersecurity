fun main(args: Array<String>) {
    // 1. Find large primes p and q
    val p = Prime().largePrime(512)
    val q = Prime().largePrime(512)
    // 2. Compute n from p and q
    // n is mod for private & public keys, n bit length is key length
    val n = RSA().n(p,q)
    // 3. Compute Phi(n) (Euler's totient function)
    // Phi(n) = (p-1)(q-1)
    // BigIntegers are objects and must use methods for algebraic operations
    val phi = RSA().getPhi(p,q)
    // 4. Find an int e such that 1 < e < Phi(n) 	and gcd(e,Phi) = 1
    val e = RSA().genE(phi)
    // 5. Calculate d where  d ≡ e^(-1) (mod Phi(n))
    val d = RSA().extEuclid(e,phi)[1]
    // Print generated values for reference
    println("p: $p")
    println("q: $q")
    println("n: $n")
    println("Phi: $phi")
    println("e: $e")
    println("d: $d")
    // encryption / decryption example
    val message = "Encryption test example"
    println("Original message: $message")
    // Convert string to numbers using a cipher
    val cipherMessage = RSA().stringCipher(message)
    println("Ciphered: $cipherMessage")
    // Encrypt the ciphered message
    val encrypted = RSA().encrypt(cipherMessage,e,n)
    println("Encrypted: $encrypted")
    // Decrypt the encrypted message
    val decrypted = RSA().decrypt(encrypted,d, n)
    println("Decrypted: $decrypted")
    // Uncipher the decrypted message to text
    val restoredMessage = RSA().cipherToString(decrypted)
    println("Restored: $restoredMessage")
}