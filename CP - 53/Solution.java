import java.io.*;
import java.util.*;

public class Solution {
    
    static int[][] commonAreas;
    static boolean[] used;
    static int[] customers;
    static boolean[] sol;
    static int N,T,M, max;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcase = 1;
        while(scan.hasNext()){
            N = scan.nextInt();
            T = scan.nextInt();
            
            if(N == 0 && T == 0){
                break;
            }
            customers = new int[N];
            for(int i = 0; i < N; i++){
                customers[i] = scan.nextInt();
            }
            M = scan.nextInt();
            commonAreas = new int[M][];
            for(int i = 0; i < M; i++){
                int t = scan.nextInt();
                commonAreas[i] = new int[t+1];
                for(int j = 0; j < t; j++){
                    commonAreas[i][j] = scan.nextInt() - 1;
                }
                commonAreas[i][t] = scan.nextInt();
            }
            used = new boolean[N];
            sol = new boolean[N];
            max = 0;
            backtrack(0,0,0);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++){
                if(sol[i]){
                    sb.append(" ").append(i+1);
                }
            }
            System.out.println("Case Number  " + testcase++);
            System.out.println("Number of Customers: " + max);
            System.out.println("Locations recommended:" + sb.toString() + "\n");
        }
    }
    
    static void backtrack(int k, int built,int total){
        if(built == T){
            total = total - commonCustomers();
            if(total > max){
                max = total;
                for(int i = 0; i < N; i++){
                    sol[i] = used[i];
                }
            }
            return;
        }
        if(k == N){
            return;
        }
        used[k] = true;
        backtrack(k+1, built + 1, customers[k] + total);
        used[k] = false;
        backtrack(k + 1, built,total);
    }
    
    static int commonCustomers(){
        int customers = 0;
        for(int i = 0; i < M; i++){
            int count = 0;
            for(int j = 0; j < commonAreas[i].length - 1; j++){
                if(used[commonAreas[i][j]]){
                    count++;
                }
            }
            if(count == 0){
                continue;
            }
            count--;
            customers = customers + count * commonAreas[i][commonAreas[i].length - 1];
        }
        return customers;
    }
}