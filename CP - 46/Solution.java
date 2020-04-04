import java.io.*;
import java.util.*;

public class Solution {
    
    public static int flag;
    public static int[] row = new int[9];
    public static int a,b;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        
        for(int i = 0; i < testcases; i++){
            scan.nextLine();
            System.out.println("SOLN       COLUMN\n #      1 2 3 4 5 6 7 8\n");
            flag = 0; 
            String[] data = scan.nextLine().split(" ");
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
            
            check(1);
            if(testcases != 0){
                System.out.println();
            }
        }
    }
    
    public static void check(int col){
        if(col == 9){
            if(row[b] == a){
                print();
            }
            return;
        }
        
        for(int i = 1; i <= 8; i++){
            if(valid(col, i)){
                row[col] = i;
                check(col + 1);
            }
        }
    }
    
    public static boolean valid(int col, int tryRow){
        for(int i = 1; i < col; i++){
            if(row[i] == tryRow || Math.abs(tryRow - row[i]) == Math.abs(col - i)){
                return false;
            }
        }
        return true;
    }
    
    public static void print(){
        System.out.print(" " + ++flag + "      ");
        for(int i = 1; i < 9; i++){
            System.out.print(row[i] + " ");
        }
        System.out.println();
    }
}