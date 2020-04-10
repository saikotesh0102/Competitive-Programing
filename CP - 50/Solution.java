import java.io.*;
import java.util.*;

public class Solution {
    
    static long min, max;
    static int num, len;
    
    public static void backtrack(long n, int length) {
        if (length == len) {
            if (n % num == 0) {
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
            return;
        }
        backtrack((n * 10) + 1, length + 1);
        backtrack((n * 10) + 2, length + 1);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for(int i = 1; i <= testcases; i++){
            String[] data = scan.nextLine().split(" ");
            int p = Integer.parseInt(data[0]);
            int q = Integer.parseInt(data[1]);
            
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            
            len = p;
            num = 1;
            
            for (int j = 0; j < q; j++){
                num = num * 2;
            }
            
            backtrack(0, 0);
            if (min == max){
                System.out.println("Case " + i + ": " + min);
            }else if (min == Long.MAX_VALUE && max == Long.MIN_VALUE){
                System.out.println("Case " + i + ": " + "impossible");
            }else{
                System.out.println("Case " + i + ": " + min + " " + max);
            }
        }
    }
}