import java.io.*;
import java.util.*;

public class Solution {
        private static int[] charCodes = { 0, 1, 2, 3, 0, 1, 2, 0, 0, 2, 2, 4, 5,
            5, 0, 1, 2, 6, 2, 3, 0, 1, 0, 2, 0, 2 };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (scn.hasNextLine()) {
            String word = scn.nextLine();
            String soundex = generateSoundex(word);
            System.out.println(word + ";" + soundex);
        }
    }

    private static String generateSoundex(String word) {
        StringBuilder sb = new StringBuilder();

        int i = 1;
        char wordChr[] = word.toCharArray();
        int lastCode = charCodes[wordChr[0] - 'A'];
        sb.append(word.charAt(0));
        while (sb.length() < 4 && i < wordChr.length) {
            int code = charCodes[wordChr[i++] - 'A'];
            if (code != 0 && code != lastCode) {
                sb.append(code);
            }
            lastCode = code;
        }

        while (sb.length() < 4) {
            sb.append(0);
        }
        return sb.toString();
    }
}