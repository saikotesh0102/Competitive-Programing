import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long ways;
    static boolean[] used;
    static int N;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            N = Integer.parseInt(data[0]);
            int K = Integer.parseInt(data[1]);
            if(N == 0 && K == 0){
                break;
            }
            used = new boolean[(2 * N) - 1];
            ways = 0;
            result(0, K);
            System.out.println(ways);
        }
    }
    
    static void result(int idx, int bishops){
        if(idx == (2 * N) - 1){
            if(bishops != 0){
                return;
            }
            long add = 1;
            for(int i = 0, even = 0, odd = 0; i < (2 * N) - 1; i++){
                if(used[i]){
                    add = add * ((i >> 1) + 1 - (i/2 % 2 == 0 ? even++ : odd++));
                }
            }
            ways = ways + add;
        }else{
            used[idx] = true;
            result(idx + 1, bishops - 1);
            used[idx] = false;
            result(idx + 1, bishops);
        }
    }
}