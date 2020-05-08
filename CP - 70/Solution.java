import java.io.*;
import java.util.*;

public class Solution {
    
    public static int[] array;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcase = 1;
        while(scan.hasNextLine()){
            int length = Integer.parseInt(scan.nextLine());
            if(length == 0){
                break;
            }
            array = new int[length];
            for(int i = 0; i < length; i++){
                array[i] = Integer.parseInt(scan.nextLine());
            }
            System.out.println("Case " + testcase++ + ":");
            while(true){
                String line = scan.nextLine();
                if(line.equals("END")){
                    System.out.println();
                    break;
                }
                String[] data = line.split(" ");
                if(data[0].equals("M")){
                    // System.out.println("Case " + testcase++);
                    measure(data);
                }
                if(data[0].equals("S")){
                    set(data);
                }
            }
        }
    }
    
    public static void measure(String[] data){
        int x = Integer.parseInt(data[1]) - 1; 
        int y = Integer.parseInt(data[2]) - 1;
        int sum = 0;
        
        for(int i = x; i <= y; i++){
            sum = sum + array[i];
        }
        System.out.println(sum);
    }
    
    public static void set(String[] data){
        int x = Integer.parseInt(data[1]) - 1;
        int y = Integer.parseInt(data[2]);
        
        array[x] = y;
    }
}