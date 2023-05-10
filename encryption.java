// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment
// ===================================================================================
// // Q-5 ) Write a JAVA Program That Performs Encryption/Decryption.
// ===================================================================================

class CaesarCipher {

    // The shift key used for encryption and decryption
    private static final int SHIFT_KEY = 3;

    public static void main(String[] args) {

        // Original plaintext to be encrypted
        String originalString = "Advanced Networking!";
        System.out.println("Original String: " + originalString);

        // Encrypt the plaintext and print the ciphertext
        String encryptedString = encrypt(originalString);
        System.out.println("Encrypted String: " + encryptedString);

        // Decrypt the ciphertext and print the plaintext
        String decryptedString = decrypt(encryptedString);
        System.out.println("Decrypted String: " + decryptedString);
    }

    /**
     * Encrypts the given plaintext using the Caesar cipher and the shift key.
     * @param value the plaintext to encrypt
     * @return the ciphertext
     */
    public static String encrypt(String value) {
        StringBuilder encryptedValue = new StringBuilder();
        for (char c : value.toCharArray()) {
            // Shift the character by the shift key and add it to the ciphertext
            encryptedValue.append(shiftChar(c, SHIFT_KEY));
        }
        return encryptedValue.toString();
    }

    /**
     * Decrypts the given ciphertext using the Caesar cipher and the shift key.
     * @param value the ciphertext to decrypt
     * @return the plaintext
     */
    public static String decrypt(String value) {
        StringBuilder decryptedValue = new StringBuilder();
        for (char c : value.toCharArray()) {
            // Shift the character back by the shift key and add it to the plaintext
            decryptedValue.append(shiftChar(c, -SHIFT_KEY));
        }
        return decryptedValue.toString();
    }

    /**
     * Shifts the given character by the given shift amount.
     * @param c the character to shift
     * @param shift the amount to shift by
     * @return the shifted character
     */
    private static char shiftChar(char c, int shift) {
        if (!Character.isLetter(c)) {
            // Do not shift non-letter characters
            return c;
        }
        int base = Character.isLowerCase(c) ? 'a' : 'A';
        int shifted = (c - base + shift) % 26;
        if (shifted < 0) {
            shifted += 26;
        }
        return (char) (base + shifted);
    }
}

//===================================================================================
// //output:
// ===================================================================================
// Original String: Advanced Networking!
// Encrypted String: Dgydqfhg Qhwzrunlqj!
// Decrypted String: Advanced Networking!
