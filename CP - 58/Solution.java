import java.io.*;
import java.util.*;

public class Solution {
    public static int[] state;
    public static int N;
    public static int id;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            id = Integer.parseInt(data[0]);
            N = Integer.parseInt(data[1]);
            state = new int[N];
            String val = data[2];
            
            for(int i = 0; i < N; i++){
                state[i] = val.charAt(i) - '0';
            }
            boolean reachable = false;
            
            for(int i = 0; i < 8; i++){
                if((id >> i)%2 == state[0]){
                    if(reachable = dp(1,(i >> 1) % 2,i % 2,(i >> 1) % 2,(i >> 2) % 2)){
                        break;
                    }
                }
            }
            
            if(!reachable){
                System.out.println("GARDEN OF EDEN");
            }else{
                System.out.println("REACHABLE");
            }
        }
    }
    
    static boolean dp(int idx, int last, int cur, int start, int end){
        if(idx == N){
            return cur == start && last == end;
        }
        for(int i = 0; i < 8; i++){
            if((id >> i)%2 == state[idx] && last == (i >> 2)%2 && cur == (i >> 1)%2){
                if(dp(idx + 1,cur,i % 2, start, end)){
                    return true;
                }
            }
        }
        return false;
    }
}