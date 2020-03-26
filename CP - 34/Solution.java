import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            long N = Long.parseLong(data[0]);
            long L = Long.parseLong(data[1]);
            long U = Long.parseLong(data[2]);
            
            long M = 0;
            for(int i = 0; i < 32; ++i){
                if((1L<<i & N) == 0){
                    M |= 1L << i;
                }
            }
            for(int i = 31; i >= 0 && (M < L || M > U); --i){
                if(M < L && (1L<<i & L) != 0){
                    M |= 1L<<i;
                }
                
                if(M > U && (1L<<i & U) == 0){
                    M &= ~(1L<<i);
                }
            }
            System.out.println(M);
        }
    }
}