// Name    : Tank Khushali B.
// Roll no : 34
// Course  : MCA 2
// Subject : Advanced Networking
// Assignment : Practicle Assignment
// ===================================================================================
// // Q-6) Write a program  in java to compute a message digest for a file of any type and any size. ===================================================================================


import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class FileDigest {

    public static void main(String[] args) {
        if (args.length != 1) {
            // Check that a filename is provided as a command-line argument
            System.out.println("Usage: java FileDigest <filename>");
            return;
        }

        String filename = args[0];
        try (FileInputStream fis = new FileInputStream(filename)) {
            // Create a new buffer for reading the file in chunks
            byte[] buffer = new byte[1024];
            // Get a MessageDigest instance for the SHA-256 algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                // Update the message digest with the bytes read from the file
                md.update(buffer, 0, bytesRead);
            }
            // Compute the final message digest and store it in a byte array
            byte[] digest = md.digest();
            // Print the message digest as a hexadecimal string
            System.out.println("SHA-256 digest for " + filename + ": " + bytesToHex(digest));
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts a byte array to a hexadecimal string.
     * @param bytes the byte array to convert
     * @return the hexadecimal string
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

// ===================================================================================
// output:
// ===================================================================================

// java FileDigest text.txt

// SHA-256 digest for text.txt: b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9
