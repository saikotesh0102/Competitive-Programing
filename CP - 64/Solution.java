import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        for(int i = 0; i < testcases; i++){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] priorities = new int[n];
            for(int j = 0; j < n; j++){
                priorities[j] = scan.nextInt();
            }
            int time = 0;
            while(true){
                time++;
                int nxt = -1;
                int p = 0; 
                int k = 0;
                for(int j = 0; j < n; j++){
                    if(priorities[j] > p){
                        p = priorities[j];
                        nxt = j;
                    }
                }
                if(nxt == m){
                    break;
                }
                if(m > nxt){
                    m -= nxt + 1;
                }else{
                    m += n - nxt - 1; 
                }
                int[] b = new int[n - 1];
                for(int j = nxt + 1; j < n; j++){
                    b[k++] = priorities[j];
                }
                for(int j = 0; j < nxt; j++){
                    b[k++] = priorities[j];
                }
                priorities = b;
                n--;
            }
            System.out.println(time);
        }
    }
}