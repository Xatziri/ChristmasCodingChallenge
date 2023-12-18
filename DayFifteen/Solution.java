import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        String input = sc.nextLine().trim();

        // Check if the input string meets the constraints
        if (input.length() >= 6 && input.length() <= 20 && input.matches("[a-zA-Z0-9]+")) {
            // Calculate and print the SHA-256 hash value
            String hashValue = calculateSHA256(input);
            System.out.println(hashValue);
        } else {
            System.out.println("Invalid input. Please make sure the string length is between 6 and 20 characters and contains only alphanumeric characters.");
        }

        sc.close();
    }

    private static String calculateSHA256(String input) {
        try {
            // Create a SHA-256 MessageDigest instance
            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");

            // Update the digest with the input bytes
            byte[] hashedBytes = sha256Digest.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                hexStringBuilder.append(String.format("%02x", b));
            }

            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}