import java.io.*;
import java.util.*;

public class Solution {
    
    static String[] dic;
    static String[] pass;
    static int N, L;
    static String rule;
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            N = Integer.parseInt(scan.nextLine());
            dic = new String[N];
            for(int i = 0; i < N; i++){
                dic[i] = scan.nextLine();
            }
            System.out.print("--\n");
            int M = Integer.parseInt(scan.nextLine());
            while(M-- > 0){
                rule = scan.nextLine();
                L = rule.length();
                pass = new String[L];
                backtrack(0);
            }
        }
    }
    
    public static void print(){
        for(int i = 0; i < L - 1; i++){
            System.out.print(pass[i]);
        }
        System.out.println(pass[L - 1]);
    }
    
    public static void backtrack(int i){
        if(i == L){
            print(); 
            return; 
        }
        
        if(rule.charAt(i) == '0'){
            for(int j = 0; j < 10; j++)
            {
                pass[i] = Integer.toString(j);
                backtrack(i+1);
            }
        }else{
            for(int j = 0; j < N; j++){
                pass[i] = dic[j];
                backtrack(i + 1);
            }
        }
    }
}