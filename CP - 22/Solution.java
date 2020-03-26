import java.io.*;
import java.util.*;

public class Solution {
    static int l, c;
    static int[] topics = new int[1002];
    static int[] dp = new int[1002];
    static int[] dp2 = new int[1002];
    
    public static int w(int t) {
        if(t == 0){
            return 0;
        }else if(t <= 10){
            return -c;
        }else {
            return ((t - 10) * (t - 10));
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int tc = 1;
        while(scan.hasNextLine()){
            int n = scan.nextInt();
            if(n == 0){
                break;
            }
            if (tc != 1){
                System.out.println();
            }
            l = scan.nextInt();
            c = scan.nextInt();
            for (int i = 0; i < n; i++){
                topics[i] = scan.nextInt();
            }
            dp[n] = dp2[n] = 0;
            for (int i = n - 1; i >= 0; i--){
                dp[i] = 1 + dp[i + 1];
                int tleft = l - topics[i];
                dp2[i] = w(tleft) + dp2[i + 1];
                for (int j = i + 1; j < n && tleft >= topics[j]; j++) {
                    tleft -= topics[j];
                    if (dp[j + 1] + 1 < dp[i]
                            || (dp[j + 1] + 1 == dp[i] && dp2[j + 1] + w(tleft) < dp2[i])) {
                        dp[i] = 1 + dp[j + 1];
                        dp2[i] = dp2[j + 1] + w(tleft);
                    }
                }

            }
            System.out.printf("Case %d:\n", tc++);
            System.out.printf("Minimum number of lectures: %d\n", dp[0]);
            System.out.printf("Total dissatisfaction index: %d\n", dp2[0]);
        }
    }
}