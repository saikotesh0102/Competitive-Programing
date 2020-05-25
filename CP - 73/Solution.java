import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int k = Integer.parseInt(data[1]);
            
            if (n == 0 && k == 0) {
                break;
            }
            
            int[] dead = new int[n];
            for (int i = 0; i < n; ++i) {
                dead[i] = i + 1;
            }
            
            int kill = k - 1;
            int bury = kill + k;
            
            kill %= n;
            bury %= n;
            int killed = 0;
            while (true) {
                ++killed;
                
                if (killed >= n - 1) {
                    break;
                }
                
                dead[kill] = dead[bury];
                dead[bury] = -1;
                
                for (int i = 0; i < k; ++i) {
                    ++kill;
                    kill %= n;
                    if (dead[kill] == -1) {
                        --i;
                    }
                }
                
                dead[kill] = -1;
                
                for (int i = 0; i < k; ++i) {
                    ++bury;
                    bury %= n;
                    if (dead[bury] == -1) {
                        --i;
                    }
                }
            }
            
            int survivor = 0;
            
            for (int i = 0; i < n; ++i) {
                if (dead[i] != -1) {
                    survivor = dead[i] - 1;
                    break;
                }
            }
            
            int lower = 0;
            int upper = survivor;
            
            while (upper != 0) {
                ++lower;
                ++upper;
                
                lower %= n;
                upper %= n;
            }
            
            System.out.println(lower + 1);
        }
    }
}