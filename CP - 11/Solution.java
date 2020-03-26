import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        long[] factorial = new long[21];
        factorial[0] = 1;
        for (int k = 1; k < factorial.length; k++) {
            factorial[k] = k * factorial[k - 1];
        }

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < t; i++) {
            String str = scan.nextLine();
            long N = Long.parseLong(scan.nextLine());
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            for (int j = 0; j < arr.length; j++) {
                long num = factorial[arr.length - j - 1];
                int val = (int) (N / num);
                sb.append(arr[val]);
                for (int m = val + 1; m < arr.length; m++) {
                    arr[m - 1] = arr[m];
                }
                N = N % num;
            }
            sb.append("\n");

        }
        System.out.println(sb);
        scan.close();
    }
}