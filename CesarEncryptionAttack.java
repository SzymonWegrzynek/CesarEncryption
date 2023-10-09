package sb;

import java.util.Scanner;

public class CesarEncryptionAttack {
    public static void main(String[] args) {
        String input = inputFromUser();
        System.out.println("originalText: " + input);

        int minDifference = Integer.MAX_VALUE;
        int foundKey = 0;
        String decryptedText = "";

        for (int key = 1; key <= 26; key++) {
            String decrypted = decrypt(input, key);
            int difference = analyzeFrequency(decrypted);

            if (difference < minDifference) {
                minDifference = difference;
                foundKey = key;
                decryptedText = decrypted;
            }
        }

        System.out.println("Key Found: " + foundKey);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    public static String inputFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your text to decrypt: ");
        String result = sc.nextLine();
        sc.close();
        return result;
    }

    public static String decrypt(String message, int key) {
        StringBuilder sb = new StringBuilder(message);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((((c - base - key + 26) % 26) + base));
                sb.setCharAt(i, c);
            }
        }
        return sb.toString();
    }

    public static int analyzeFrequency(String text) {
        double[] expectedFrequency = {
                8.17, 1.49, 2.78, 4.25, 12.70, 2.23, 2.02, 6.09,
                6.97, 0.15, 0.77, 4.03, 2.41, 6.75, 7.51, 1.93,
                0.09, 5.99, 6.33, 9.06, 2.76, 0.98, 2.36, 0.15,
                1.98, 0.07
        };

        int totalDifference = 0;

        int[] actualFrequency = new int[26];
        text = text.toLowerCase();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = c - 'a';
                actualFrequency[index]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            int difference = Math.abs(actualFrequency[i] - (int) (text.length() * (expectedFrequency[i] / 100.0)));
            totalDifference += difference;
        }

        return totalDifference;
    }
}
