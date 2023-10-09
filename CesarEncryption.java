package sb;

import java.util.Scanner;

public class CesarEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = CesarEncryption.inputFromUser(scanner);
        System.out.println("Original Text: " + input);

        int shift = CesarEncryption.getShiftFromUser(scanner);
        String encrypted = CesarEncryption.encrypt(input, shift);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = CesarEncryption.decrypt(encrypted, shift);
        System.out.println("Decrypted Text: " + decrypted);

        scanner.close();
    }

    public static String inputFromUser(Scanner scanner) {
        System.out.println("Enter your text to encrypt: ");
        return scanner.nextLine();
    }

    public static int getShiftFromUser(Scanner scanner) {
        System.out.println("Enter the shift value (an integer): ");
        return scanner.nextInt();
    }

    public static String encrypt(String message, int shift) {
        StringBuilder sb = new StringBuilder(message);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (((c - base + shift) % 26) + base);
                sb.setCharAt(i, c);
            }
        }
        return sb.toString();
    }

    public static String decrypt(String message, int shift) {
        StringBuilder sb = new StringBuilder(message);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (((c - base - shift + 26) % 26) + base);
                sb.setCharAt(i, c);
            }
        }
        return sb.toString();
    }
}
