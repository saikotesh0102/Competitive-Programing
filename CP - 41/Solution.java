import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int flag = 0;
        
        while(scan.hasNextLine()){
            int N = Integer.parseInt(scan.nextLine());
            if(N == 0){
                break;
            }
            
            if(flag != 0){
                System.out.print("\n");
            }else{
                flag++;
            }
            
            int start = 01234;
            int end = 98765 / N;
            
            boolean found = false;
            
            for(int i = start; i <= end; i++){
                int num = i * N;
                if(unique(i,num)){
                    String numerator = String.format("%05d", num);
                    String denominator = String.format("%05d", i);
                    System.out.print(numerator + " / " + denominator + " = " + N + "\n");
                    found = true;
                }
            }
            
            if(!found){
                System.out.print("There are no solutions for " + N + ". \n");
            }
        }
    }
    
    public static boolean unique(int start, int end){
        int[] numbers = new int[10];
        for(int i = 0; i < 5; i++){
            int x = start % 10;
            if(numbers[x] == 1){
                return false;
            }
            numbers[x]++;
            start = start / 10;
        }
        
        for(int i = 5; i < 10; i++){
            int x = end % 10;
            if(numbers[x] == 1){
                return false;
            }
            numbers[x]++;
            end = end / 10;
        }
        return true;
    }
}