import java.io.*;
import java.util.*;

public class Solution {
    
    public static int[] start;
    public static int[] end;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int m = Integer.parseInt(data[1]);
            if(n == 0 && m == 0){
                break;
            }
            
            start = new int[1000001];
            end = new int[1000001];
            while(n-- > 0){
                String[] nonrepeated = scan.nextLine().split(" ");
                int x = Integer.parseInt(nonrepeated[0]);
                int y = Integer.parseInt(nonrepeated[1]);
                start[x]++;
                end[y]++;
            }
            while(m-- > 0){
                String[] repeated = scan.nextLine().split(" ");
                int x = Integer.parseInt(repeated[0]);
                int y = Integer.parseInt(repeated[1]);
                int z = Integer.parseInt(repeated[2]);
                for(int i = x; i <= 1000000; i= i + z){
                    start[i]++;
                }
                for(int i = y; i <= 1000000; i = i + z){
                    end[i]++;
                }
            }
            if(check()){
                System.out.println("NO CONFLICT");
            }else{
                System.out.println("CONFLICT");
            }
        }
    }
    
    public static boolean check(){
        int tasks = 0;
        for(int i = 0; i <= 1000000; i++){
            tasks = tasks + start[i] - end[i];
            if(tasks > 1){
                return false;
            }
        }
        return true;
    }
}