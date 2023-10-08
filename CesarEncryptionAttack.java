package sb;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CesarEncryptionAttack {
    // alphabet
    // (32) !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz (122)
    public CesarEncryptionAttack() {

    }

    public static void main(String[] args) {
        String input = CesarEncryptionAttack.inputFromUser();
        System.out.println(input);
        String encrypted = CesarEncryptionAttack.encrypt(input);
        System.out.println(encrypted);
        String decrypted = CesarEncryptionAttack.decrypt(encrypted);
        System.out.println(decrypted);
    }

    public static String inputFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your text to encrypt: ");
        String result = sc.nextLine();
        sc.close();
        return result;
    }

    public static String encrypt(String message) {
        StringBuilder sb = new StringBuilder(message);
        int distance = 5;
        for (int i = 0; i < sb.length(); i++) {
            int c = (int)sb.charAt(i);
            if (c + distance > 122) {
                c = 31 + (distance - (122 - c));
            }
            else {
                c += distance;
            }
            sb.setCharAt(i, (char)c);
        }
        return sb.toString();
    }

    public static String decrypt(String message) {
        StringBuilder sb = new StringBuilder(message);
        int distance = 5;
        for (int i = 0; i < sb.length(); i++) {
            int c = (int)sb.charAt(i);
            if (c - distance < 32) {
                c = 123 - (distance - (c - 32));
            }
            else {
                c -= distance;
            }
            sb.setCharAt(i, (char)c);
        }
        return sb.toString();
    }

    public static void dict(String[] args) {
        Map<Character, Integer> dictionary = new HashMap<>();

        dictionary.put('A', 6);
        dictionary.put('B', 35);
        dictionary.put('C', 30);
        dictionary.put('D', 21);
        dictionary.put('F', 31);
        dictionary.put('G', 38);
        dictionary.put('H', 16);
        dictionary.put('I', 1);
        dictionary.put('J', 61);
        dictionary.put('K', 53);
        dictionary.put('L', 16);
        dictionary.put('M', 26);
        dictionary.put('N', 7);
        dictionary.put('O', 3);
        dictionary.put('P', 33);
        dictionary.put('Q', 61);
        dictionary.put('R', 10);
        dictionary.put('S', 8);
        dictionary.put('U', 21);
        dictionary.put('V', 37);
        dictionary.put('W', 23);
        dictionary.put('X', 67);
        dictionary.put('Y', 36);
        dictionary.put('Z', 80);
    }
}
